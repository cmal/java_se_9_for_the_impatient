package ch01.ex;

import java.util.Random;
import java.util.LinkedList;
import java.util.ArrayList;

public class Lottery {
    public static void main(String[] args) {
        final int bound = 49;
        LinkedList<Integer> lst = new LinkedList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < bound; i ++) {
            lst.add(i + 1);
        }

        for (int i = 0; i < 6; i ++) {
            int rand = (new Random()).nextInt(bound - i);
            Integer removed = lst.remove(rand);
            res.add(removed);
        }
        System.out.println(res);
    }
}
