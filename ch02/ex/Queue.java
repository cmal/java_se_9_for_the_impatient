package ch02.ex;

public class Queue {
    private static class Node {
        public int val;
        public Node next; // default null
        Node(int argVal) {
            val = argVal;
        }
    }

    private Node head;
    Queue() {
    }

    public void add(int argVal) {
        Node newNode = new Node(argVal);
        
    }

    public void remove() {
        
    }
}
