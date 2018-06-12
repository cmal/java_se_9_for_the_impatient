package ch02.ex;

import java.util.Stack;

public class NonVoidMutator {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println(stack.empty());
        Integer i = stack.push(3);
        System.out.println(stack.empty());
        System.out.printf("stack changed, push has non void return value %d\n", i);

        
    }
}
