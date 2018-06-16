package ch06.ex;

import java.util.ArrayList;

public class StackArrayList<E> {

    private ArrayList<E> elements;

    StackArrayList() {
        elements = new ArrayList<>();
    }

    public boolean push(E e) {
        return elements.add(e);
    }

    public E pop() throws IndexOutOfBoundsException {
        int index = elements.size();
        return elements.remove(index - 1);
    }

    public boolean isEmpty() {
        return elements.size() == 0;
    }

    public static void main(String[] args) {
        StackArrayList<String> stack = new StackArrayList<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        String c = stack.pop();
        String b = stack.pop();
        boolean notEmpty = stack.isEmpty();
        String a = stack.pop();
        boolean empty = stack.isEmpty();
        System.out.printf("%s, %s, %s, %b, %b", c, b, a, notEmpty, empty);
    }
}
