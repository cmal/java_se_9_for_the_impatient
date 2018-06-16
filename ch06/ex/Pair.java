package ch06.ex;

public class Pair<E> {
    private E k;
    private E v;

    Pair(E k, E v) {
        this.k = k;
        this.v = v;
    }

    public E getFirst() {
        return k;
    }

    public E getSecond() {
        return v;
    }

    public static void main(String[] args) {
        String a = "A";
        String b = "B";
        Pair<String> p = new Pair<String>(a, b);
        System.out.println(p.getFirst());
        System.out.println(p.getSecond());
    }
}
