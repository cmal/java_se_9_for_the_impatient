package ch04.ex;

import java.lang.Math;
import java.lang.reflect.Method;
import java.util.function.DoubleFunction;

public class PrintStaticDoubleMethods {

    public static void printTable(Method m, double lowerBound, double upperBound, double step) {
        try {
            double limit = (upperBound - lowerBound) / step;
            System.out.println(m.getName());
            for (int i = 0; i < limit; i ++) {
                System.out.println(m.invoke(null, lowerBound + i * step));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void printTable1(DoubleFunction<Object> f, double lowerBound, double upperBound, double step) {
            double limit = (upperBound - lowerBound) / step;
            System.out.println(f);
            for (int i = 0; i < limit; i ++) {
                System.out.println(f.apply(lowerBound + i * step));
            }
        
    }

    public static void main (String[] args) {
        try {
            Method sqrt = Math.class.getDeclaredMethod​("sqrt", double.class);
            Method toHexString = Double.class.getDeclaredMethod("toHexString", double.class);
            printTable(sqrt, 30, 50, 2);
            printTable(toHexString, 30, 50, 2);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("---- Repeat ----");
        DoubleFunction<Object> sqrt = Math::sqrt;
        DoubleFunction<Object> toHexString = Double::toHexString;
        printTable1(sqrt, 30, 50, 2);
        printTable1(toHexString, 30, 50, 2);

    }
}
