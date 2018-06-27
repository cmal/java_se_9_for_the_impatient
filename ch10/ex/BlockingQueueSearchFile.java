package ch10.ex;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.stream.*;
import java.util.regex.*;

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

    // 15. Repeat the preceding exercise, using a global
    // ConcurrentHashMap for collecting the word frequencies.

    // 16. Repeat the preceding exercise, using parallel streams. None
    // of the stream operations should have any side effects.

    public LinkedBlockingQueue<File> lbq = new LinkedBlockingQueue<>();
    public LinkedBlockingQueue<HashMap<String, Integer>> hmq = new LinkedBlockingQueue<>();

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

    public class RemoveAndCompileThread extends Thread {
        private HashMap<String, Integer> hm;
        private File f;

        RemoveAndCompileThread(File f) {
            super();
            this.f = f;
            this.hm = new HashMap<>();
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
                        addWord(m.group());
                    }
                }
                hmq.put(hm);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        private void addWord(String word) {
            hm.compute(word, (k, v) -> (v == null) ? 1 : v + 1);
        }
    }

    public static TreeSet<Map.Entry<String, Integer>> sortEntries(Map<String, Integer> m) {
        TreeSet<Map.Entry<String, Integer>> result = new
            TreeSet<Map.Entry<String, Integer>>(new
                                                Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> e1,
                                       Map.Entry<String, Integer> e2) {
                        return e1.getValue().compareTo(e2.getValue());
                    }
                });
        result.addAll(m.entrySet());
        return result;
    }


    public class MergeThread extends Thread {
        private HashMap<String, Integer> hm;
        // private SortedSet<Map.Entry<String, Integer>> ss;
        MergeThread() {
            super();
            hm = new HashMap<>();
            // ss = new SortedSet<>();
        }
        
        @Override
        public void run() {
            // merge hmq print 10 most frequent word
            hmq.forEach(hm::putAll);
            TreeSet<Map.Entry<String, Integer>> ts = sortEntries(hm);
            for (int i = 0; i < 10; i ++) {
                System.out.println(ts.pollLast());
            }
        }
    }
    
    public static void main(String[] args) {

        BlockingQueueSearchFile b = new BlockingQueueSearchFile();

        ExecutorService exectr = Executors.newCachedThreadPool();
        WalkThread tWalk = b.new WalkThread();
        exectr.submit(tWalk);

        List<Callable<Map<String, Integer>>> tasks = new ArrayList<>();

        ExecutorCompletionService<Map<String, Integer>> executor = new ExecutorCompletionService<>(exectr);

        int count = 0;
        try {
            while(true) {
                File f = b.lbq.take();
                if (f.getPath() == "dummy") {
                    break;
                }
                count ++;
                // RemoveAndCompileThread t = b.new RemoveAndCompileThread(f);
                Callable<Map<String, Integer>> task = () -> {
                    HashMap<String, Integer> hm = new HashMap<>();
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(f));
                        String line;
                        String pattern = "(\\w+)";
                        Pattern r = Pattern.compile(pattern);
                        while ((line = br.readLine()) != null) {
                            Matcher m = r.matcher(line);
                            while(m.find()) {
                                hm.compute(m.group(), (k, v) -> (v == null) ? 1 : v + 1);
                            }
                        }
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    return hm;
                };
                executor.submit(task);
                // tasks.add(task);
            }

            // the final thread
            // List<Future<Map<String, Integer>>> results = executor.invokeAll(tasks);
            HashMap<String, Integer> total = new HashMap<>();
            // results.stream().forEach(ft -> {
            //         try {
            //             total.putAll(ft.get());
            //         } catch (Exception e) {
            //             e.printStackTrace();
            //         }
                    
            //     });
            for (int i = 0; i < count; i ++) {
                Map<String, Integer> m = executor.take().get();
                try {
                    total.putAll(m);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            TreeSet<Map.Entry<String, Integer>> ts = sortEntries(total);
            for (int i = 0; i < 10; i ++) {
                System.out.println(ts.pollLast());
            }

            exectr.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
