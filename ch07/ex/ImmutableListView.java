package ch07.ex;

import java.util.*;

public class ImmutableListView {

    public static Iterator<Integer> genView(int n) {
        return new Iterator<Integer>() {
            private int current;

            @Override
            public boolean hasNext() {
                return current <= n;
            }

            @Override
            public Integer next() {
                if (current > n) {
                    throw new NoSuchElementException("went too far");
                }
                return current ++;
            }
        };
    }

    public static void main(String[] args) {
        Iterator<Integer> iter = genView(10);
        for (int i = 0; i <= 10; i ++) {
            System.out.println(iter.hasNext()); // true
            System.out.println(iter.next()); // 0-n
        }
        System.out.println(iter.hasNext()); // false
        System.out.println(iter.next()); // throws
    }
}
