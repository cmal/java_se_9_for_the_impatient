package ch07.ex;

import java.util.ArrayList;
import java.util.ListIterator;

public class UpperString {
    private ArrayList<String> strs;

    UpperString() {
        strs = new ArrayList<>();
    }

    public void addStr(String s) {
        strs.add(s);
    }

    public void upperCaseIter() {
        ListIterator<String> iter = strs.listIterator();
        while(iter.hasNext()) {
            iter.set(iter.next().toUpperCase());
        }
    }

    public void upperCaseLoopIndex() {
        for (int i = 0; i < strs.size(); i ++) {
            strs.set(i, strs.get(i).toUpperCase());
        }
    }

    public void upperCaseReplaceAll() {
        strs.replaceAll(String::toUpperCase);
    }

    public void print() {
        for (String s : strs) {
            System.out.println(s);
        }
    }

    public void clear() {}

    public static void main(String[] args) {
        UpperString str = new UpperString();
        str.addStr("hello");
        str.addStr("c++");
        str.print();
        str.upperCaseIter();
        str.print();

        str = new UpperString();
        str.addStr("hello");
        str.addStr("c++");
        str.print();
        str.upperCaseLoopIndex();
        str.print();

        str = new UpperString();
        str.addStr("hello");
        str.addStr("c++");
        str.print();
        str.upperCaseReplaceAll();
        str.print();
    }
}
