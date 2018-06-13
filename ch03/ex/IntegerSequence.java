package ch03.ex;


public class IntegerSequence implements IntSequence {
    private int[] ints;
    private int cursor;
    private boolean constantQ;
    private int constant;

    IntegerSequence (int argConstant) {
        constantQ = true;
        constant = argConstant;
    }

    IntegerSequence (int[] argInts) {
        constantQ = false;
        cursor = 0;
        ints = argInts;
    }
    

    public boolean hasNext() {
        if (constantQ) {
            return true;
        } else {
            // System.out.println(cursor);
            // System.out.println(ints.length);
            return cursor < ints.length;
        }
    }

    public int next() {
        if (constantQ) {
            return constant;
        } else {
            return ints[cursor++];
        }
    }
    
    public static IntegerSequence of (int... args) {
        return new IntegerSequence(args);
    }

    public static IntegerSequence constant (int arg) {
        return new IntegerSequence(arg);
    }

    public static void main(String[] args) {
        IntegerSequence seq = IntegerSequence.of(1,2,3,4,5,6);
        while (seq.hasNext()) {
            System.out.printf("%d ", seq.next());
        }
        System.out.println();

        IntegerSequence constSeq = IntegerSequence.constant(1);
        for (int i = 0; i < 10; i ++) {
            System.out.printf("%d ", constSeq.next());
        }
        System.out.println();
    }
}

