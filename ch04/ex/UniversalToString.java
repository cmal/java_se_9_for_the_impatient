package ch04.ex;

import java.util.ArrayList;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import ch04.ex.Point;
import ch04.ex.Circle;

public class UniversalToString {
    public static ArrayList<String> universalToString(Class c) {
        Field[] fields = c.getDeclaredFields();
        Class<?> superC = c.getSuperclass();
        ArrayList<String> fieldStrs = new ArrayList<String>();
        if (superC.getName() != "java.lang.Object") {
            for (String s : universalToString(superC)) {
                fieldStrs.add(s);
            }
        }
        for (Field f : fields) {
            fieldStrs.add(f.getName());
        }
        return fieldStrs;
    }

    public static void main(String[] args) {
        Point p = new Point(3.5, 4);
        Circle circle = new Circle(p, 2.5);
        for (String s : universalToString(circle.getClass())) {
            System.out.println(s);
        }
    }
}
