package ch06.ex;

import java.util.ArrayList;

public class AppendToAnother {

    public static <E> void appendTo1(ArrayList<E> from, ArrayList<? super E> to) {
        for (E e : from) {
            to.add(e);
        }
    }

    public static <E> void appendTo2(ArrayList<? extends E> from, ArrayList<E> to) {
        for (E e : from) {
            to.add(e);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> from = new ArrayList<String>();
        ArrayList<Object> to1 = new ArrayList<Object>();
        ArrayList<Object> to2 = new ArrayList<Object>();
        from.add("A");
        from.add("B");
        appendTo1(from, to1);
        System.out.println(to1.get(0));
        System.out.println(to1.get(1));
        appendTo2(from, to2);
        System.out.println(to2.get(0));
        System.out.println(to2.get(1));
    }
}
