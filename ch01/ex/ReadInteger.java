package ch01.ex;

import java.util.Scanner;

public class ReadInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is the integer?");

        int input = in.nextInt();
        double out_double = (double) input;
        System.out.printf("int: %d, octal: %o, double: %.2f, hex: %x", input, input, out_double, input);
        System.out.printf("\nreciprocal: %a", 1/out_double);
    }
}

