package ch03.ex;

import java.util.Random;

public class RandomSequence{

    private static Random generator = new Random();

    public static class RandomSeq implements IntSequence {
        private int low;
        private int high;

        RandomSeq(int argLow, int argHigh) {
            low = argLow;
            high = argHigh;
        }
        
        public int next() {
            return low + generator.nextInt(high - low + 1);
        }
        public boolean hasNext() {
            return true;
        }
    }

    public static IntSequence randomInts(int low, int high) {
        return new RandomSeq(low, high);
    }

    public static void main(String[] args) {
        IntSequence ints = randomInts(1, 8);
        for (int i = 0; i < 10; i ++) {
            System.out.printf("%d ", ints.next());
        }
    }
}
