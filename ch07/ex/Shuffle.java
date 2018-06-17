package ch07.ex;

import java.util.*;
import java.util.Scanner;

public class Shuffle {

    private ArrayList<String> lst;

    Shuffle() {
        lst = new ArrayList<>();
    }

    public void shufflePart() {
        int len = lst.size();
        if (len < 2)
            return;
        List<String> part = lst.subList(1, len - 1);
        Collections.shuffle(part);
    }

    public void read() {
        Scanner in = new Scanner(System.in);
        String inStr = in.nextLine();
        for (String s : inStr.split(" ")) {
            lst.add(s);
        }
    }

    public void print() {
        for (String s : lst) {
            System.out.printf("%s ", s);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.print("Give me a sentence: ");
        Shuffle sf = new Shuffle();
        sf.read();
        sf.shufflePart();
        sf.print();
    }

}
