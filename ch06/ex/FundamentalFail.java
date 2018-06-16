package ch06.ex;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.IntFunction;

public class FundamentalFail {

    public static <T> T[] repeat(int n, T obj, IntFunction<T[]> constr) {
        T[] result = constr.apply(n);
        for (int i = 0; i < n; i ++)
            result[i] = obj;
        return result;
    }

    public static <T> ArrayList<T> repeat(int n, T obj) {
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < n; i ++)
            result.add(obj);
        return result;
    }

    @SafeVarargs
    public static final <T> T[] repeat(int n, T... objs) {
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            for (T t : objs) {
                result.add(t);
            }
        }
        return result.toArray(objs);
    }

    public static void main(String[] args) {
        Integer[] ints = repeat(10, 1, Integer[]::new);
        Integer[] ints2 = repeat(3, 1, 2, 3);
        for (Integer i : ints2) {
            System.out.println(i);
        }
    }
}
