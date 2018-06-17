package ch07.ex;

import java.util.Set;
import java.util.HashSet;

public class SetOps {
    private Set<Integer> set;

    SetOps() {
        set = new HashSet<>();
    }

    public Set<Integer> getSet() {
        return set;
    }

    public void add(int i) {
        set.add(i);
    }

    public void print() {
        System.out.printf("#{");
        for (Integer i : set) {
            System.out.printf("%d ", i);
        }
        System.out.printf("}\n");
    }

    public void union(SetOps other) {
        set.addAll(other.getSet());
    }

    public void intersection(SetOps other) {
        set.retainAll(other.getSet());
    }

    public void difference(SetOps other) {
        set.removeAll(other.getSet());
    }

    public static void main(String[] args) {
        SetOps s1 = new SetOps();
        s1.add(0);
        s1.add(1);
        s1.add(4);

        SetOps s = new SetOps();
        s.add(1);
        s.add(2);
        s.add(3);
        s.union(s1);
        s.print();

        s = new SetOps();
        s.add(1);
        s.add(2);
        s.add(3);
        s.intersection(s1);
        s.print();

        s = new SetOps();
        s.add(1);
        s.add(2);
        s.add(3);
        s.difference(s1);
        s.print();

    }
}
