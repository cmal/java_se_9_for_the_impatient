package ch10.ex;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;

public class ReadAllWords {
    // 6. “Write an application in which multiple threads read all
    // words from a collection of files. Use a
    // ConcurrentHashMap<String, Set<File>> to track in which files
    // each word occurs. Use the merge method to update the map.”

    // 7. Repeat the preceding exercise, but use computeIfAbsent
    // instead. What is the advantage of this approach?

    ConcurrentHashMap<String, Set<File>> chm;

    ReadAllWords() {
        chm = new ConcurrentHashMap<>();
    }

    public void addWord(String word, File file) {
        // first approach:
        // if (chm.get(word) == null) {
        //     HashSet<File> set = new HashSet<>();
        //     set.add(file);
        //     chm.put(word, file);
        // } else {
        //     chm.get(word).add(file);
        // }

        // second: with a merge method:
        // HashSet<File> set = new HashSet<>();
        // set.add(file);
        // chm.merge(word, set, (s1, s2) -> {
        //         s1.addAll(s2);
        //         return s1;
        //     });

        // third: with computeIfAbsent
        chm.computeIfAbsent(word, w -> new HashSet<File>()).add(file);
    }

    public class AddWordThread extends Thread {
        private File f;

        AddWordThread(File file) {
            f = file;
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
                        addWord(m.group(), this.f);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void print() {
        for(Map.Entry<String, Set<File>> entry: chm.entrySet()) {
            String key = entry.getKey();
            Set<File> value = entry.getValue();
            System.out.println(key + " => " + value);
        }

    }

    public static void main(String[] args) {
        try {
            ReadAllWords rw = new ReadAllWords();
            Path path = Paths.get(".");
            Stream<Path> sp = Files.walk(path);
            sp.parallel()
                // keep away from MalformedInputException
                .filter(p -> p.toString().endsWith(".java"))
                .forEach(p -> {
                        Thread t = rw.new AddWordThread(p.toFile());
                        t.start();
                    });

            rw.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
