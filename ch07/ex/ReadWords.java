package ch07.ex;

import java.util.*;
import java.io.*;
import java.util.regex.*;

public class ReadWords {
    private TreeMap<String, Integer> tm;
    private TreeMap<String, ArrayList<Integer>> tml;

    ReadWords() {
        tm = new TreeMap<>();
        tml = new TreeMap<>();
    }

    public void addWord(String s) {
        if (tm.containsKey(s)) {
            int v = tm.get(s);
            tm.put(s, v + 1);
        } else {
            tm.put(s, 1);
        }
    }

    public void addWordLine(String s, int line) {
        if (tml.containsKey(s)) {
            ArrayList<Integer> v = tml.get(s);
            v.add(line);
            tml.put(s, v);
        } else {
            ArrayList<Integer> v = new ArrayList<>();
            v.add(line);
            tml.put(s, v);
        }
    }

    public void print() {
        for(Map.Entry<String,Integer> entry: tm.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " => " + value);
        }
    }

    public void printLine() {
        for(Map.Entry<String, ArrayList<Integer>> entry: tml.entrySet()) {
            String key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            System.out.println(key + " => " + value);
        }
    }

    public void readFile(String filename) throws FileNotFoundException, IOException {
        File file = new File(filename);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        String pattern = "(\\w+)";
        Pattern r = Pattern.compile(pattern);
        int linum = 0;
        while ((line = br.readLine()) != null) {
            linum ++;
            Matcher m = r.matcher(line);
            while(m.find()) {
                addWord(m.group());
                addWordLine(m.group(), linum);
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
        rw.printLine();
    }
}
