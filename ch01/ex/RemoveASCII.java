package ch01.ex;

import java.util.Scanner;

public class RemoveASCII {

    public static void main(String[] args) {

        System.out.printf("Give me a string: ");
        Scanner in = new Scanner(System.in);
        String inStr = in.nextLine();

        for (char c : inStr.toCharArray()) {
            // TODO
            System.out.println(c);
        }
    }
}

