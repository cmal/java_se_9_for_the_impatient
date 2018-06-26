package ch10.ex;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.stream.*;

// 3. Implement a method yielding a task that reads through all words
// in a file, trying to find a given word. The task should finish
// immediately (with a debug message) when it is interrupted. For all
// files in a directory, schedule one task for each file. Interrupt
// all others when one of them has succeeded.

public class FindWord {

    public static class SearchWordThread extends Thread {

        private Path path;
        private String word;
        private ArrayList<SearchWordThread> pool;

        SearchWordThread(Path p, String wd, ArrayList<SearchWordThread> po) {
            super();
            path = p;
            word = wd;
            pool = po;
        }

        @Override
        public void run() {
            try {
                findWord(path, word);
            } catch (InterruptedException e) {
                System.out.printf("Thread " + e + " interrupted");
            }
        }

        public void findWord(Path path, String word) throws InterruptedException {
            if (Files.isRegularFile(path) && Files.isReadable(path)) {
                try(Stream<String> s = Files.lines(path)) {
                    // here has a problem: Exception in thread
                    // "Thread-1" java.io.UncheckedIOException:
                    // java.nio.channels.ClosedByInterruptException
                    Optional<String> result = s.filter(line -> line.contains(word)).findFirst();
                    result.ifPresent(res -> this.interruptOthers(res));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    throw e;
                }
            } else {
                System.out.println("not a valid file to search");
            }
        }

        public void interruptOthers(String s) {
            pool.stream().forEach(t -> {
                    if (t == this) {
                        System.out.println(s);
                    } else {
                        t.interrupt();
                    }
                });
        }

    }

    
    public static void main(String[] args) {
        ArrayList<SearchWordThread> pool = new ArrayList<>();
        Path p1 = Paths.get("./ch10/ex/HowLargeFaster.java");
        Path p2 = Paths.get("/usr/share/dict/words");
        SearchWordThread thread1 = new SearchWordThread(p1, "parallel", pool);
        SearchWordThread thread2 = new SearchWordThread(p2, "parallel", pool);
        pool.add(thread1);
        pool.add(thread2);
        thread1.start();
        thread2.start();
    }
}
