package ch01.ex;

import java.util.Scanner;

public class PrintSubs {

        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Give me a string: ");
        String s = in.nextLine();
        // System.out.printf("You give me: %s\n", s);
        System.out.println("Substrings are: ");

        // String[] words = s.split("\\s+");
        // for (String subs : words) {
        for (String subs : s.split("\\s+")) {
            System.out.println(subs);
        }
    }

}
