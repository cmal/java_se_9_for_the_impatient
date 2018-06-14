package ch04.ex;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class MethodPrinter {

    public static void print(String className) throws ClassNotFoundException {
        Class<?> cl = Class.forName(className);
        while (cl != null) {
            for (Method m : cl.getDeclaredMethods()) {
                System.out.println(Modifier.toString(m.getModifiers())
                                   + " " + m.getReturnType().getCanonicalName()
                                   + " " + m.getName()
                                   + Arrays.toString(m.getParameters()));
            }
            cl = cl.getSuperclass();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{};
        try {
            print(arr.getClass().getName());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
