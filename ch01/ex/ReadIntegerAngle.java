package ch01.ex;

import java.util.Scanner;
import java.lang.Math;

public class ReadIntegerAngle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("What is the integer: ");
        int input = in.nextInt();
        int angle = input % 360;
        int normalizedAngle = angle >= 0 ? angle : angle + 360;
        int normalizedAngleFloor = Math.floorMod(input, 360);
        System.out.printf("Angle: %d, %d", normalizedAngle, normalizedAngleFloor);
    }
}

