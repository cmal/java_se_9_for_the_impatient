package ch01.ex;

import java.util.Random;

public class RandLong {

    public static void main(String[] args) {

        long rand = (new Random()).nextLong();
        System.out.printf(Long.toString(rand, 36));
    }
}

