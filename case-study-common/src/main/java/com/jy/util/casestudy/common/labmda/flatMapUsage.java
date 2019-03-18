package com.jy.util.casestudy.common.labmda;

import java.util.*;
import java.util.stream.Collectors;

public class flatMapUsage {
    public static void main(String[] args) {
        List<List<String>> list = Arrays.asList(
            Arrays.asList("a","b", "c"),
            Arrays.asList("d", "e"));
        System.out.println(list);
        System.out.println(list
            .stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList()));

        System.out.println("================================================================");

        Map<Integer, List<String>> idNamesMap = new HashMap<>();
        List<String> names1 = new ArrayList<>();
        names1.add("xiaoming");
        names1.add("xiaohong");
        names1.add("xiaoli");
        idNamesMap.put(1, names1);

        List<String> names2 = new ArrayList<>();
        names2.add("xiaoming");
        names2.add("xiaohong");
        names2.add("xiaoli");
        idNamesMap.put(2, names2);
        System.out.println(idNamesMap.values());
        List<String> nameList = idNamesMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(nameList);
    }
}
