package ch04.ex;

import java.util.ArrayList;

public class ClassMethods {

    public static class InnerClass {
        
    }

    public static void sixMethods(Object o) {
        Class c = o.getClass();
        System.out.printf("Class: %s\n", c);
        System.out.printf("getCanonicalName: %s\n", o.getClass().getCanonicalName());
        System.out.printf("getName: %s\n", o.getClass().getName());
        // System.out.println(o.getClass().getPackageName()); // java 9
        System.out.printf("getSimpleName: %s\n", o.getClass().getSimpleName());
        System.out.printf("getTypeName: %s\n", o.getClass().getTypeName());
        System.out.printf("toGenericString: %s\n", o.getClass().toGenericString());
        System.out.printf("toString: %s\n", o.getClass().toString());
        System.out.println();
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
