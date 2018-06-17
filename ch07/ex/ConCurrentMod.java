package ch07.ex;

import java.util.ListIterator;
import java.util.ArrayList;

public class ConCurrentMod {

    private ArrayList<Integer> lst;
    private ListIterator<Integer> iter1;
    private ListIterator<Integer> iter2;

    ConCurrentMod() {
        lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        iter1 = lst.listIterator();
        iter2 = lst.listIterator();
    }

    public void makeException() {
        int i1 = -1;
        int i2 = -1;
        if (iter1.hasNext()) {
            i1 = iter1.next();
        }
        if (iter2.hasNext()) {
            i2 = iter2.next();
        }

        System.out.printf("%d, %d\n", i1, i2);
        iter1.remove();
        iter2.set(5); // ConcurrentModificationException, this is a RuntimeException
        System.out.println(lst);

    }

    public static void main(String[] args) {
        ConCurrentMod ccm = new ConCurrentMod();
        ccm.makeException();
    }

}
