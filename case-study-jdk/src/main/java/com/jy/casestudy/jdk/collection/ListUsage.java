package com.jy.casestudy.jdk.collection;

import java.util.ArrayList;
import java.util.List;

public class ListUsage {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(String.join("/", list));
    }
}
