package ch01.ex;

import java.util.Scanner;
import java.math.BigInteger;

public class Factorial {

    public static BigInteger factorial(int i) {
        BigInteger res = new BigInteger("1");
        for (; i > 0; i --) {
            res = res.multiply(new BigInteger(Integer.toString(i)));
        }
        return res;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Factorial of: ");
        int input = in.nextInt();

        BigInteger res = factorial(input);
        System.out.printf("Factorial of %d is: %s", input, res.toString());
    }
}

