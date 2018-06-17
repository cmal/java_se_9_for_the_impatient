package ch07.ex;

import ch07.ex.SieveErathostenesHashSet;
import ch07.ex.SieveErathostenesBitSet;

public class SieveErathostenes {

    public static void main(String[] args) {
         SieveErathostenesHashSet s1 = new SieveErathostenesHashSet(200);
         do {
             s1.removeMulti();
         } while (s1.forwardCursor() != -1);
         s1.print();

         SieveErathostenesBitSet s2 = new SieveErathostenesBitSet(200);
         do {
             s2.removeMulti();
         } while (s2.forwardCursor() != -1);
         s2.print();

    }
}
