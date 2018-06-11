package ch01.ex;

import java.util.Scanner;

public class ComputeUnsign {

    public static int usum(int i, int j) {
        return i + j;
    }

    public static int udiff(int i, int j) {
        return i - j;
    }

    public static int uprod(int i, int j) {
        return i * j;
    }

    public static int uquot(int i, int j) {
        return i / j;
    }

    public static int urem(int i, int j) {
        return i % j;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Two integers from 0 and 4294967295");
        System.out.print("The first: ");
        int first = in.nextInt();
        System.out.print("The second: ");
        int second = in.nextInt();

        // TODO
        int usum = usum(first, second);
        int udiff = udiff(first, second);
        int uprod = uprod(first, second);
        int uquot = uquot(first, second);
        int urem = urem(first, second);

        System.out.printf("Unsigned sum of %d and %d is: %d\n", first, second, usum);
        System.out.printf("Unsigned diff of %d and %d is: %d\n", first, second, udiff);
        System.out.printf("Unsigned prod of %d and %d is: %d\n", first, second, uprod);
        System.out.printf("Unsigned quot of %d and %d is: %d\n", first, second, uquot);
        System.out.printf("Unsigned rem of %d and %d is: %d\n", first, second, urem);
    }
}

