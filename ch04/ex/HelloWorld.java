package ch04.ex;

import java.lang.reflect.Method;
import java.io.PrintStream;

public class HelloWorld {

    public static void reflectPrintln() {
        PrintStream out = System.out;

        Class<?> c = System.out.getClass();

        try {
            Method m = c.getDeclaredMethod​("println", String.class);
            m.invoke(System.out, "Hello World!");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 2000000; i ++) {
            System.out.println("Hello World!");
        }

        long regularCallTime = System.currentTimeMillis();

        for (int i = 0; i < 2000000; i ++) {
            reflectPrintln();
        }

        long endTime = System.currentTimeMillis();

        System.out.printf("Regular call time: %d ms\n", regularCallTime - startTime);
        System.out.printf("Reflect call time: %d ms\n", endTime - regularCallTime);
        System.out.println("Regular call time wins.");
    }
}
