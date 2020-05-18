package com.jy.casestudy.jdk.labmda;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yj
 * @since 2020-05-18 14:46
 **/
public class InitCollection {

    public static void main(String[] args) {
        initList();
        initSet();
        initMap();
    }

    private static void initMap() {
        Map<String, Integer> map = Stream.of(new AbstractMap.SimpleEntry<>("a", 1), new AbstractMap.SimpleEntry<>("b", 2))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("map: " + map);
    }

    private static void initSet() {
        Set<String> set = Stream.of("a", "b", "c", "c").collect(Collectors.toSet());
        System.out.println("set: " + set);
    }

    private static void initList() {
        List<String> list = Stream.of("a", "b", "c", "c").collect(Collectors.toList());
        System.out.println("list: " + list);
    }

}
