package ch09.ex;

import java.nio.file.*;
import java.nio.*;
import java.util.*;
import java.io.*;

public class Toc {

    private static TreeMap<String, ArrayList<Integer>> tm = new TreeMap<>();
    
    public static void Toc(String filename) {
        Path in = Paths.get(filename);
        int i = filename.lastIndexOf('.');
        String toc = filename.substring(0, i + 1) + "toc";
        
        String line;

        try {
            BufferedReader br = Files.newBufferedReader(in);
            int lineNo = 1;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (tm.containsKey(word)) {
                        tm.get(word).add(lineNo);
                    } else {
                        ArrayList<Integer> arr = new ArrayList<>();
                        arr.add(lineNo);
                        tm.put(word, arr);
                    }
                }
                lineNo ++;
            }

            Path out = Paths.get(toc);
            BufferedWriter bw = Files.newBufferedWriter(out);
            for (String k : tm.keySet()) {
                String s = k + ": " + tm.get(k).toString() + "\n";
                bw.write(s);
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public static void main(String[] args) {
        Toc("finally.txt");
    }
}
