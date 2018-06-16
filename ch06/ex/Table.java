package ch06.ex;

import ch06.ex.Entry;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Table<K, V> {
    private ArrayList<Entry<K, V>> entries;

    public Table() {
        entries = new ArrayList<Entry<K, V>>();
    }

    public V getValue(K key) throws NoSuchElementException {
        ListIterator<Entry<K, V>> iter = entries.listIterator();
        for (;;) {
            Entry<K, V> entry = iter.next();
            if (entry.getKey() == key) {
                return entry.getValue();
            }
        }
    }

    public void put(K key, V value) {
        entries.add(new Entry<>(key, value));
    }

    public void remove(K key) {
        // assume all keys are different,
        // not consider dup keys.
        ListIterator<Entry<K, V>> iter = entries.listIterator();
        while(iter.hasNext()) {
            Entry<K, V> entry = iter.next();
            if (entry.getKey() == key) {
                iter.remove();
                return;
            }
        }
    }

    public static void main(String[] args) {
        Table<String, Integer> t = new Table<String, Integer>();
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
