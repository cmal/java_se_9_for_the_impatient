package ch07.ex;

import java.util.RandomAccess;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class EfficientSwap {

    public static <T> void swap(List<T> list, int i, int j) {
        if (list instanceof RandomAccess) {
            T tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
        } else {
            int min, max;
            if (i < j) {
                min = i;
                max = j;
            } else {
                min = j;
                max = i;
            }
            ListIterator<T> iter = list.listIterator();
            for (int index = 0; index < min; index ++) {
                iter.next();
            }
            T tmp1 = iter.next();
            for (int index = min + 1; index < max; index ++) {
                iter.next();
            }
            T tmp2 = iter.next();
            iter.set(tmp1);
            for (int index = max + 1; index > min; index --) {
                iter.previous();
            }
            iter.set(tmp2);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> alst = new ArrayList<>();
        for (int i = 0; i < 5; i ++) {
            alst.add(i);
        }
        swap(alst, 0, 4);
        System.out.println(alst);

        LinkedList<Integer> llst = new LinkedList<>();
        for (int i = 0; i < 5; i ++) {
            llst.add(i);
        }
        swap(llst, 0, 4);
        System.out.println(llst);

    }
}
