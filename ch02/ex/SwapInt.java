package ch02.ex;

import java.lang.Integer;
import org.omg.CORBA.IntHolder;

public class SwapInt {

    public static void swap(IntHolder a, IntHolder b) {
        int tmp = a.value;
        a.value = b.value;
        b.value = tmp;
    }
    
    public static void main(String[] args) {
        System.out.println("int is primitive type, and not object. So can not be changed.");
        System.out.println("Integer is immuatable.");
        IntHolder a = new IntHolder(1);
        IntHolder b = new IntHolder(2);
        System.out.printf("a, b: %d, %d\n", a.value, b.value);
        swap(a, b);
        System.out.printf("a, b: %d, %d\n", a.value, b.value);
    }
}

