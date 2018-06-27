package ch10.ex;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;

public class BlockingQueueSearchFile {

    // 11. Use a blocking queue for processing files in a
    // directory. One thread walks the file tree and inserts files
    // into a queue. Several threads remove the files and search each
    // one for a given keyword, printing out any matches. When the
    // producer is done, it should put a dummy file into the queue.

    // 12. Repeat the preceding exercise, but instead have each
    // consumer compile a map of words and their frequencies that are
    // inserted into a second queue. A final thread merges the
    // dictionaries and prints the ten most common words. Why don't
    // you need to use a ConcurrentHashMap?

    // 13. Repeat the preceding exercise, making a
    // Callable<Map<String, Integer>> for each file and using an
    // appropriate executor service. Merge the results when all are
    // available. Why don't you need to use a ConcurrentHashMap?

    // 14. Use an ExecutorCompletionService instead and merge the
    // results as soon as they become available.

    //15. Repeat the preceding exercise, using a global
    // ConcurrentHashMap for collecting the word frequencies.

    // 16. Repeat the preceding exercise, using parallel streams. None
    // of the stream operations should have any side effects.

    public LinkedBlockingQueue<File> lbq = new LinkedBlockingQueue<>();

    public class WalkThread extends Thread {
        @Override
        public void run() {
            try {
                Path path = Paths.get(".");
                Stream<Path> sp = Files.walk(path);
                sp.filter(p -> p.toString().endsWith(".java")
                          && Files.isRegularFile(p)
                          && Files.isReadable(p))
                    .forEach(p -> {
                            try{
                                lbq.put(p.toFile());   
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });

                lbq.put(new File("dummy"));
                // System.out.println(lbq.size());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class RemoveAndSearchThread extends Thread {
        private File f;

        RemoveAndSearchThread(File f) {
            super();
            this.f = f;
        }
        
        @Override
        public void run() {
            String word = "extends";
            try(Stream<String> s = Files.lines(f.toPath())) {
                s.filter(line -> line.contains(word))
                    .forEach(System.out::println);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {

        BlockingQueueSearchFile b = new BlockingQueueSearchFile();

        ExecutorService executor = Executors.newCachedThreadPool();
        WalkThread tWalk = b.new WalkThread();
        executor.submit(tWalk);

        try {
            while(true) {
                File f = b.lbq.take();
                if (f.getPath() == "dummy") {
                    executor.shutdown();
                    break;
                }
                RemoveAndSearchThread t = b.new RemoveAndSearchThread(f);
                executor.submit(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
