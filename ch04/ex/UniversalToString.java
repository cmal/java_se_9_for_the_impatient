package ch04.ex;

import java.util.ArrayList;
import java.lang.reflect.Field;
import ch04.ex.Point;
import ch04.ex.Circle;

public class UniversalToString {
    public static ArrayList<String> universalToString(Object o) {
        Class c = o.getClass();
        Field[] fields = c.getDeclaredFields();
        ArrayList<String> fieldStrs = new ArrayList<String>();
        for (Field f : fields) {
            fieldStrs.add(f.getName());
        }
        System.out.println(fields.length);
        return fieldStrs;
    }

    public static void main(String[] args) {
        Point p = new Point(3.5, 4);
        Circle c = new Circle(p, 2.5);
        for (String s : universalToString(c)) {
            System.out.println(s);
        }
    }
}
