package ch07.ex;

import java.util.BitSet;

public class SieveErathostenesBitSet {

    private BitSet bs;
    private int cursor;
    private int ceiling;

    SieveErathostenesBitSet(int n) {
        bs = new BitSet(n); // default false
        bs.set(0); // remove 1
        cursor = 1; // pos 1 represent int 2
        ceiling = n;
    }

    public int forwardCursor() {
        cursor = bs.nextClearBit(cursor + 1);
        if (cursor < 0 || cursor >= ceiling)
            return -1;
        return cursor;
    }

    public void removeMulti() {
        int base = cursor + 1; // pos 1 represent int 2
        for (int i = base; ; i ++) {
            int n = i * base;
            if (n <= ceiling) {
                bs.set(n - 1); // pos 1 represent int 2
            } else {
                break;
            }
        }
    }

    public void print() {
        int cnt = 0;
        System.out.println("---- BitSet ----");
        int i = 0;
        for (;;) { // i is a pos
            i = bs.nextClearBit​(i + 1);
            if (i < 0 || i >= ceiling)
                break;
            cnt ++;
            System.out.printf("%d\t", i + 1);
            if (cnt % 5 == 0)
                System.out.println();
        }
        if (cnt % 5 != 0)
            System.out.println();
        System.out.printf("Total %d elements left.\n", cnt);
    }


}
