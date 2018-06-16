package ch06.ex;

import java.util.function.Function;
import java.util.ArrayList;

public class Map {

    private static ArrayList<String> testArr;

    Map() {
        testArr = new ArrayList<String>();
        testArr.add("A");
        testArr.add("B");
        testArr.add("C");
    }

    public String get(int i) {
        return testArr.get(i);
    }

    public static <T, R> ArrayList<R> map(ArrayList<T> arr, Function<T, R> f) {
        ArrayList<R> ret = new ArrayList<R>();
        for (T e : arr) {
            ret.add(f.apply(e));
        }
        return ret;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Map mp = new Map();
        arr.add(2);
        arr.add(0);
        arr.add(1);
        try {
            ArrayList<String> res = map(arr, (i) -> mp.get(i));
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
