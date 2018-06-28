package ch10.ex;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.util.regex.*;

public class ThreadedCountWord {
    // 1. Write a program that walks a directory tree and generates a
    // thread for each file. In the threads, count the number of words
    // in the files and, without using locks, update a shared counter
    // that is declared as public static long count = 0;

    // Run the program multiple times. What happens? Why?

    // 2. Fix the program of the preceding exercise with using a
    // lock.

    // 3. Fix the program of the preceding exercise with using a
    // LongAdder.

    public long count = 0;
    LongAdder la = new LongAdder();
    
    public class CountWordThread extends Thread {
        private File f;
        CountWordThread(File f) {
            this.f = f;
        }

        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;
                String pattern = "(\\w+)";
                Pattern r = Pattern.compile(pattern);
                while ((line = br.readLine()) != null) {
                    Matcher m = r.matcher(line);
                    while(m.find()) {
                        count ++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    ReentrantLock lock = new ReentrantLock();

    public class CountWordLockThread extends Thread {
        private File f;
        CountWordLockThread(File f) {
            this.f = f;
        }

        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;
                String pattern = "(\\w+)";
                Pattern r = Pattern.compile(pattern);
                while ((line = br.readLine()) != null) {
                    Matcher m = r.matcher(line);
                    while(m.find()) {
                        // It's important to wrap your code into a
                        // try/finally block to ensure unlocking in case
                        // of exceptions.
                        lock.lock();
                        try {
                            count++;
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            lock.unlock();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

    public class CountWordLongAdderThread extends Thread {
        private File f;
        CountWordLongAdderThread(File f) {
            this.f = f;
        }

        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;
                String pattern = "(\\w+)";
                Pattern r = Pattern.compile(pattern);
                while ((line = br.readLine()) != null) {
                    Matcher m = r.matcher(line);
                    while(m.find()) {
                        la.increment();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void runThreads(Stream<Path> s) {
        // this MAY get inconsistent results
        try {
            count = 0;
            ArrayList<Thread> ts = new ArrayList<>();
            s.forEach(p -> {
                    CountWordThread t = new CountWordThread(p.toFile());
                    t.start();
                    ts.add(t);
                });
            ts.stream().forEach(t -> {
                    try {
                        t.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            System.out.printf("(NoLock) count: %d\n", count);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void runThreadsWithLock(Stream<Path> s) {
        // this SHOULD NOT generate in-consistent results
        try {
            count = 0;
            ArrayList<Thread> ts = new ArrayList<>();
            s.forEach(p -> {
                    CountWordLockThread t = new CountWordLockThread(p.toFile());
                    t.start();
                    ts.add(t);
                });
            ts.stream().forEach(t -> {
                    try {
                        t.join();   
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            
                });
            System.out.printf("(Lock) count: %d\n", count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runThreadsWithLongAdder(Stream<Path> s) {
        // this SHOULD NOT generate in-consistent results
        try {
            count = 0;
            ArrayList<Thread> ts = new ArrayList<>();
            s.forEach(p -> {
                    CountWordLongAdderThread t = new CountWordLongAdderThread(p.toFile());
                    t.start();
                    ts.add(t);
                });
            ts.stream().forEach(t -> {
                    try {
                        t.join();   
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            System.out.printf("(LongAdder) count: %d\n", la.sum());
            la.reset();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        // run multi times
        try {
            for (int i = 0; i < 20; i ++) {
                Path path = Paths.get(".");
                Stream<Path> sp = Files.walk(path);
                Stream<Path> s = sp.filter(p -> p.toString().endsWith(".java")
                                           && Files.isRegularFile(p)
                                           && Files.isReadable(p));
                ThreadedCountWord tcw = new ThreadedCountWord();
                // tcw.runThreads(s); // this MAY get inconsistent results
                // tcw.runThreadsWithLock(s); // this SHOULD NOT get inconsistent results
                tcw.runThreadsWithLongAdder(s); // this SHOULD NOT get inconsistent results
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

