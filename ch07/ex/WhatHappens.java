package ch07.ex;

import java.util.*;

public class WhatHappens {

    // MUST USE THIS:
    // public static void WhatHappens(Map<String, ? extends Set<Integer>> mp) {
    public static void WhatHappens(Map<String, Set<Integer>> mp) {
        return;
    }

    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        HashMap<String, HashSet<Integer>> hm = new HashMap<>();
        hm.put("A", hs);
        WhatHappens(hm); //不兼容的类型: HashMap<String,HashSet<Integer>>无法转换为Map<String,Set<Integer>>
    }
}
