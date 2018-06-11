package ch01.ex;

import java.lang.Math;

public class PrintPosDoubleRange {
    public static void main(String[] args) {
        System.out.printf("The smallest positive double: %f\n", Double.MIN_VALUE);
        System.out.printf("The smallest again: %f\n", Math.nextUp(0));
        System.out.printf("The largest double: %f\n" , Double.MAX_VALUE);
        System.out.printf("What happens if cast a large double to int? : %d", (int)Double.MAX_VALUE);
        // Maybe double has been truncated to int?
    }
}

