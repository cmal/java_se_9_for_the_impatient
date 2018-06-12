package ch01.ex;

import java.util.Scanner;

public class ComputeUnsign {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("First integer from 0 and 4294967295: ");
        int first = Integer.parseUnsignedInt(in.nextLine());
        System.out.print("Second integer from 0 and 4294967295: ");
        int second = Integer.parseUnsignedInt(in.nextLine());

        // TODO
        int usum = first + second;
        int udiff = first - second;
        int uprod = first * second;
        int uquot = Integer.divideUnsigned(first, second);
        int urem = Integer.remainderUnsigned(first, second);

        System.out.printf("Unsigned sum of %s and %s is: %s\n",
                          Integer.toUnsignedString(first),
                          Integer.toUnsignedString(second),
                          Integer.toUnsignedString(usum));
        System.out.printf("Unsigned diff of %s and %s is: %s\n",
                          Integer.toUnsignedString(first),
                          Integer.toUnsignedString(second),
                          Integer.toUnsignedString(udiff));
        System.out.printf("Unsigned prod of %s and %s is: %s\n",
                          Integer.toUnsignedString(first),
                          Integer.toUnsignedString(second),
                          Integer.toUnsignedString(uprod));
        System.out.printf("Unsigned quot of %s and %s is: %s\n",
                          Integer.toUnsignedString(first),
                          Integer.toUnsignedString(second),
                          Integer.toUnsignedString(uquot));
        System.out.printf("Unsigned rem of %s and %s is: %s\n",
                          Integer.toUnsignedString(first),
                          Integer.toUnsignedString(second),
                          Integer.toUnsignedString(urem));
    }
}

