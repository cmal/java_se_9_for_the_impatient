package ch10.ex;

// 20. Consider this stack implementation:

// Describe two different ways in which the data structure can fail to
// contain the correct elements.

public class WrongStack {
    class Node {
        Object value;
        Node next;
    }
    
    private Node top;

    public void push(Object newValue) {
        Node n = new Node();
        n.value = newValue;
        n.next = top;
        top = n;
    }

    public Object pop() {
        if (top == null) return null;
        Node n = top;
        top = n.next;
        return n.value;
    }

    public String toString() {
        String s = "|<- ";
        Node n = top;
        while (n != null) {
            s += n.value;
            s += " <- ";
            n = n.next;
        }
        return s + "top";
    }

    public static void main(String[] args) {
        WrongStack s = new WrongStack();
        s.push("A");
        s.push("B");
        s.push("C");
        System.out.println(s);
        s.pop();
        s.push("D");
        System.out.println(s);
        s.pop();
        s.pop();
        s.pop();
        System.out.println(s);
    }
}


