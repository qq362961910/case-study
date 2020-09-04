package com.jy.casestudy.jdk.collection;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapUsage {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>(Collections.reverseOrder());
        for(int i=0; i<20; i++) {
            treeMap.put(i, String.valueOf(i));
        }
        System.out.println("treeMap: " + treeMap);
        treeMap = treeMap.entrySet().stream().limit(5).collect(TreeMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
        System.out.println("treeMap: " + treeMap);
    }
}
