package com.jy.util.casestudy.common.labmda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapUsage {

    public static void main(String[] args) {

        List<String> strList = Stream.of("a", "b")
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println(strList);


        List<Dog> dogList = Stream.of("a", "b")
            .map(Dog::new)
            .collect(Collectors.toList());
        System.out.println(dogList);
    }
}

class Dog {

    private String name;

    Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "dog: " + name;
    }
}
