package ch03.ex;

import java.math.BigInteger;

public class SquareSequence implements Sequence<BigInteger> {

    private BigInteger i;

    SquareSequence() {
        i = new BigInteger("0");
    }

    public boolean hasNext() {
        return true;
    }

    public BigInteger next() {
        i = i.add(BigInteger.ONE);
        return i.multiply(i);
    }

    public static void main(String[] args) {
        SquareSequence squares = new SquareSequence();
        for (int i = 0; i < 10; i ++) {
            System.out.printf("%s ", squares.next().toString());
        }
    }
}
