package ch06.ex;

import java.util.Arrays;
import java.util.function.IntFunction;

public class StackArray<E> {

    private E[] elements;

    StackArray(IntFunction<E[]> constructor) {
        elements = constructor.apply(0);
    }

    public void push(E e) {
        int size = elements.length;
        elements = Arrays.copyOf(elements, size + 1);
        elements[size] = e;
    }

    public E pop() throws NegativeArraySizeException {
        int index = elements.length;
        E ret = elements[index - 1];
        elements =  Arrays.copyOf(elements, index - 1);
        return ret;
    }

    public boolean isEmpty() {
        return elements.length == 0;
    }

    public static void main(String[] args) {
        StackArray<String> stack = new StackArray<String>(String[]::new);
        for (String s : "A B C".split(" "))
            stack.push(s);
        String c = stack.pop();
        String b = stack.pop();
        boolean notEmpty = stack.isEmpty();
        String a = stack.pop();
        boolean empty = stack.isEmpty();
        System.out.printf("%s, %s, %s, %b, %b", c, b, a, notEmpty, empty);
    }
}
