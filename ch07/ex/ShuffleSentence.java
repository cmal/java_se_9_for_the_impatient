package ch07.ex;

import java.util.*;
import java.util.Scanner;

public class ShuffleSentence {

    private ArrayList<String> lst;
    private String punct;

    ShuffleSentence() {
        lst = new ArrayList<>();
    }

    public void shuffle() {
        Collections.shuffle(lst);
    }

    private String capitalize(final String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

    public void read() {
        Scanner in = new Scanner(System.in);
        String inStr = in.nextLine();
        String[] strs = inStr.split(" ");
        for (int i = 0; i < strs.length; i ++) {
            if (i == strs.length - 1) {
                String s = strs[i];
                punct = s.substring(s.length() - 1);
                if (s.length() > 1)
                    lst.add(s.substring(0, s.length() - 1));
            } else {
                lst.add(strs[i]);
            }
        }
    }

    public void print() {
        System.out.printf("%s ", capitalize(lst.get(0)));
        int i;
        for (i = 1; i < lst.size() - 1; i ++) {
            System.out.printf("%s ", lst.get(i));
        }
        System.out.print(lst.get(i));
        System.out.print(punct);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.print("Give me a sentence: ");
        ShuffleSentence sf = new ShuffleSentence();
        sf.read();
        sf.shuffle();
        sf.print();
    }

}
