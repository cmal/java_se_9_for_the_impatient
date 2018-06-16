package ch06.ex;

import ch06.ex.Entry;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class TableNested<K, V> {
    private ArrayList<Entry> entries;

    private class Entry { // can not be static
        // not static can refer to the outer class's instance
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
    }

    public TableNested() {
        entries = new ArrayList<Entry>();
    }

    public V getValue(K key) throws NoSuchElementException {
        ListIterator<Entry> iter = entries.listIterator();
        for (;;) {
            Entry entry = iter.next();
            if (entry.getKey() == key) {
                return entry.getValue();
            }
        }
    }

    public void put(K key, V value) {
        entries.add(new Entry(key, value));
    }

    public void remove(K key) {
        // assume all keys are different,
        // not consider dup keys.
        ListIterator<Entry> iter = entries.listIterator();
        while(iter.hasNext()) {
            Entry entry = iter.next();
            if (entry.getKey() == key) {
                iter.remove();
                return;
            }
        }
    }

    public static void main(String[] args) {
        TableNested<String, Integer> t = new TableNested<String, Integer>();
        t.put("A", 1);
        t.put("B", 2);
        t.put("C", 3);

        System.out.println(t);
        System.out.println(t.getValue("C"));
        t.remove("C");
        System.out.println(t.getValue("A"));
        // t.getValue("C");
        t.remove("B");
        System.out.println(t.getValue("A"));
        t.remove("A");
        // System.out.println(t.getValue("A"));
    }

}
