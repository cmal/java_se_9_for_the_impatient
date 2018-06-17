package ch07.ex;

import java.util.*;
import java.io.*;
import java.util.regex.*;

public class ReadWords {
    private TreeMap<String, Integer> tm;

    ReadWords() {
        tm = new TreeMap<>();
    }

    public void addWord(String s) {
        if (tm.containsKey(s)) {
            int v = tm.get(s);
            tm.put(s, v + 1);
        } else {
            tm.put(s, 1);
        }
    }

    public void print() {
        for(Map.Entry<String,Integer> entry: tm.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " => " + value);
        }
    }

    public void readFile(String filename) throws FileNotFoundException, IOException {
        File file = new File(filename);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        String pattern = "(\\w+)";
        Pattern r = Pattern.compile(pattern);
        while ((line = br.readLine()) != null) {
            Matcher m = r.matcher(line);
            while(m.find()) {
                addWord(m.group());
            }
        }
    }

    public static void main(String[] args) {
        ReadWords rw = new ReadWords();
        try {
            rw.readFile("words.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        rw.print();
    }
}
