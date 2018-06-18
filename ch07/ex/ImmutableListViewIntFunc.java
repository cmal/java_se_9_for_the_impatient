package ch07.ex;

import java.util.*;
import java.util.function.*;

public class ImmutableListViewIntFunc {

    public static Iterator<Integer> genView(IntFunction<Integer> f) {
        return new Iterator<Integer>() {
            private int current;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return f.apply(current);
            }
        };
    }

    public static void main(String[] args) {
        Iterator<Integer> iter = genView(a -> a + 1);
        for (int i = 0; i <= 10; i ++) {
            System.out.println(iter.hasNext()); // true
            System.out.println(iter.next()); // 0-n
        }
        System.out.println(iter.hasNext()); // false
        System.out.println(iter.next()); // throws
    }

}
