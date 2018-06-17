package ch07.ex;

import java.util.ArrayList;
import java.util.HashSet;

public class SieveErathostenesHashSet {

    private HashSet<Integer> hs;
    private int cursor;
    private int ceiling;

    SieveErathostenesHashSet(int n) {
        hs = new HashSet<Integer>(n - 1);
        cursor = 2;
        ceiling = n;
        for (int i = cursor; i <= n; i ++) {
            hs.add(i);
        }
    }

    public int forwardCursor() {
        cursor ++;
        for (; cursor * cursor <= ceiling; cursor ++) {
            if (hs.contains(cursor)) {
                return cursor;
            }
        }
        return -1;
    }

    public void removeMulti() {
        for (int i = cursor; ; i ++) {
            int multi = i * cursor;
            if (multi <= ceiling) {
                hs.remove(multi);
            } else {
                break;
            }
        }
    }

    public void print() {
        ArrayList<Integer> lst = new ArrayList<Integer>(ceiling - 1);
        lst.addAll(hs);
        lst.sort(Integer::compare);
        int cnt = 0;
        System.out.println("---- HashSet ----");
        for (int i : lst) {
            System.out.printf("%d\t", i);
            cnt ++;
            if (cnt % 5 == 0) {
                System.out.println();
            }
        }
        if (cnt % 5 != 0) {
            System.out.println();
        }
        System.out.printf("Total %d elements left.\n", lst.size());
    }
}
