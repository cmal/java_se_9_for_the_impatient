package ch02.ex;

public class Queue {
    private static class Node {
        public int val;
        public Node next; // default null
        Node(int argVal) {
            val = argVal;
        }
    }

    // here MUST be NON STATIC!
    // Because Iterator must keep a reference
    // to one of outer class's nodes
    private class Iterator {
        public Node current;
        Iterator () {
            current = head;
        }
        public Node next() {
            if (!hasNext()) {
                System.out.println("DO NOT has next!");
                return null;
            }
            Node tmp = current;
            current = current.next;
            return tmp;
        }
        public boolean hasNext() {
            return !(current == null);
        }
        public void reset() {
            iter.current = head;
        }
    }

    private Node head;
    private int cnt = 0;
    private Iterator iter;
    Queue() {
        iter = new Iterator();
    }

    public void add(int argVal) {
        System.out.printf("adding %d.\n", argVal);
        Node newNode = new Node(argVal);
        if (head == null) {
            head = newNode;
        } else if (head.next == null) {
            head.next = newNode;
        } else {
            Node cur = head.next;
            for (; cur.next != null; cur = cur.next) {
            }
            cur.next = newNode;
        }
        cnt ++;
        iter.reset();
        System.out.printf("%d added.\n", argVal);
    }

    public int remove() {
        if (cnt == 0) {
            System.out.println("Empty Queue, CANNOT Remove!");
            return 0;
        }
        int ret = head.val;
        head = head.next;
        cnt --;
        iter.reset();
        System.out.printf("Removed %d\n", ret);
        return ret;
    }

    public int size() {
        return cnt;
    }

    public void traverse() {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.printf("<- %d ", cur.val);
        }
        System.out.println();
    }

    public Iterator iterator() {
        return iter;
    }

    public void iterTraverse() {
        Iterator it = new Iterator();
        while (it.hasNext()) {
            System.out.printf("<- %d ", it.next().val);
        }
        System.out.println();
    }

    static public void main(String[] args) {
        Queue q = new Queue();
        q.add(3);
        q.add(4);
        q.add(5);
        q.traverse();
        q.iterTraverse();
        int a = q.remove();
        int b = q.remove();
        int c = q.remove();
        System.out.printf("Now size: %d, first removed: %d, then removed: %d, last removed: %d",
                          q.size(), a, b, c);
    }
}
