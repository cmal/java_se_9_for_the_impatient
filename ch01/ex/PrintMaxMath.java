package ch01.ex;

import java.util.Scanner;
import java.lang.Math;

public class PrintMaxMath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Give me 3 integers and you get the max.\nThe first:");
        int first = in.nextInt();
        System.out.print("The second:");
        int second = in.nextInt();
        System.out.print("The third:");
        int third = in.nextInt();
        int max = Math.max(first, second);
        max = Math.max(max, third);
        System.out.printf("Now you got the Max: %d", max);
    }
}

