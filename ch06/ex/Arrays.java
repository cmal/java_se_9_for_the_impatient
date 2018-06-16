package ch06.ex;

import ch06.ex.Pair;
import java.util.ArrayList;

public class Arrays {
    // public static <T> void swap(T[] array, int i, int j) {
    //     T temp = array[i];
    //     array[i] = array[j];
    //     array[j] = temp;
    // }

    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }

    public static <E extends Comparable> Pair<E> firstLast(ArrayList<? extends E> a) {
        int len = a.size();
        return new Pair(a.get(0), a.get(len - 1));
    }

    public static <E extends Comparable> E min(ArrayList<? extends E> a)  {
        E tmp = a.get(0);
        for (E e : a) {
            if (e.compareTo(tmp) < 0) {
                tmp = e;
            }
        }
        return tmp;
    }

    public static <E extends Comparable> E max(ArrayList<? extends E> a) {
        E tmp = a.get(0);
        for (E e : a) {
            if (e.compareTo(tmp) > 0) {
                tmp = e;
            }
        }
        return tmp;
    }

    public static <E extends Comparable> Pair<E> minMax(ArrayList<? extends E> a) {
        return new Pair(min(a), max(a));
    }

    public static void main(String[] args) {
        // String[] friends = new String[]{"A", "B", "C"};
        // Arrays.swap(friends, 0, 1);
        // System.out.printf("%s, %s, %s", friends[0], friends[1], friends[2]);
        Double[] result = Arrays.<Double>swap(0, 1, 1.5, 2.0, 3.0);
        System.out.printf("%f, %f, %f\n", result[0], result[1], result[2]);

        ArrayList<Double> arr = new ArrayList<Double>();
        arr.add(1.5);
        arr.add(2.0);
        arr.add(3.0);
        Pair<Double> p = firstLast(arr);
        System.out.printf("%f, %f\n", p.getFirst(), p.getSecond());

        Pair<Double> mp = minMax(arr);
        System.out.printf("MIN: %f\n", min(arr));
        System.out.printf("MAX: %f\n", max(arr));
        System.out.printf("PAIR MIN: %f\n", mp.getFirst());
        System.out.printf("PAIR MAX: %f\n", mp.getSecond());
    }
}
