package ch03.ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Lucky {

    public static boolean luckySort(ArrayList<String> strings, Comparator<String> comp) {
        Collections.shuffle(strings);
        for (int i = 1; i < strings.size(); i++) {
            if (comp.compare(strings.get(i - 1), strings.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Tom");
        strings.add("Jack");
        System.out.println("I tried once.");
        while(!luckySort(strings, String.CASE_INSENSITIVE_ORDER)) {
            System.out.println("I tried once.");
        }
        System.out.println(strings);
    }
}
