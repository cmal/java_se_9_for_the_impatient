package ch07.ex;

import java.util.*;
import java.util.function.*;

public class Merge {

    private HashMap<String, Integer> hm;

    Merge() {
        hm = new HashMap<>();
    }

    public void mergeContains(String key,
                              Integer value,
                              BiFunction<? super Integer,? super Integer,? extends Integer> f) {
        if (hm.containsKey(key)) {
            hm.put(key, f.apply(hm.get(key), value));
        } else {
            hm.put(key, f.apply(0, value));
        }
    }


    public void mergeGetCheck(String key,
                              Integer value,
                              BiFunction<? super Integer,? super Integer,? extends Integer> f) {
        if (hm.get(key) == null) {
            hm.put(key, f.apply(0, value));
        } else {
            hm.put(key, f.apply(hm.get(key), value));
        }
    }

    public void mergeGetOrDefault(String key,
                                  Integer value,
                                  BiFunction<? super Integer,? super Integer,? extends Integer> f) {
        hm.put(key, f.apply(hm.getOrDefault(key, 0), value));
    }

    public void mergePutIfAbsent(String key,
                                 Integer value,
                                 BiFunction<? super Integer,? super Integer,? extends Integer> f) {
        if (hm.putIfAbsent(key, f.apply(0, value)) != null) {
            hm.put(key, f.apply(hm.get(key), value));
        }
    }

    public void print() {
        for(Map.Entry<String,Integer> entry: hm.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " => " + value);
        }
    }


    public static void main(String[] args) {
        Merge m = new Merge();

        m.print();

        m.mergeContains("A", 1, Integer::sum);
        m.mergeGetCheck("B", 1, Integer::sum);
        m.mergeGetOrDefault("C", 1, Integer::sum);
        m.mergePutIfAbsent("D", 1, Integer::sum);

        m.print();

        m.mergeContains("A", 10, Integer::sum);
        m.mergeGetCheck("B", 10, Integer::sum);
        m.mergeGetOrDefault("C", 10, Integer::sum);
        m.mergePutIfAbsent("D", 10, Integer::sum);

        m.print();
    }

}
