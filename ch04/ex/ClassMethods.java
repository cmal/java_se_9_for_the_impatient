package ch04.ex;

import java.util.ArrayList;

public class ClassMethods {

    public static class InnerClass {
        
    }

    public static void sixMethods(Object o) {
        Class c = o.getClass();
        System.out.println(o.getClass().getName());
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{};
        ArrayList<Integer> alInt = new ArrayList<Integer>();
        InnerClass in = new InnerClass();
        int a = 0;
        
        sixMethods(arr);
        sixMethods(alInt);
        sixMethods(in);
        sixMethods(a);
    }
}
