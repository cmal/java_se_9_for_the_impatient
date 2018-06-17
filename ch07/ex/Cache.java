package ch07.ex;

import java.util.*;

public class Cache<K,V> extends LinkedHashMap<K,V>{

    private int max_entries;

    Cache(int n) {
        super();
        max_entries = n;
    }

    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > max_entries;
    }

    public static void main(String[] args) {
        Cache<String, Integer> cache = new Cache<>(2);
        cache.put("A", 1);
        cache.put("B", 2);
        System.out.println(cache.size());
        cache.put("C", 3);
        System.out.println(cache.size());
        cache.put("D", 3);
        System.out.println(cache.size());
    }
}
