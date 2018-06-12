package ch02.ex;

import java.lang.Integer;
import java.util.ArrayList;
import java.util.Random;

public class RandomNumber {
    static final Random rand = new Random();

    static int randomElement (int[] arr) {
        int randIndex = rand.nextInt(arr.length + 1);
        return arr[randIndex];
    }

    static Integer randomElement (ArrayList<Integer> arrList) {
        int randIndex = rand.nextInt(arrList.size() + 1);
        return arrList.get(randIndex);
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(randomElement(arr));

        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for (int i = 1; i < 6; i ++) {
            arrList.add(i);
        }
        System.out.println(randomElement(arrList));
    }
}

