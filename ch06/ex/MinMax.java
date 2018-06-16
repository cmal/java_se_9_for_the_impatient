package ch06.ex;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class MinMax {
    public static <T> void minmax(List<T> elements,
                                  Comparator<? super T> comp,
                                  List<? super T> result) {
        T min = elements.get(0);
        T max = elements.get(0);
        for (T e : elements) {
            if (comp.compare(min, e) > 0) {
                min = e;
            }
            if (comp.compare(max, e) < 0) {
                max = e;
            }
        }
        result.add(min);
        result.add(max);
    }

    public static void main(String[] args) {
        ArrayList<String> lst = new ArrayList<String>();
        ArrayList<Object> res = new ArrayList<Object>();
        lst.add("A");
        lst.add("B");
        lst.add("C");
        lst.add("1");
        minmax(lst, (a, b) -> a.compareTo(b), res);
        System.out.println(res.get(0));
        System.out.println(res.get(1));
    }
}
