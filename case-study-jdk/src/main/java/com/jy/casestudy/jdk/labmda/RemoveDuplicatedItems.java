package com.jy.casestudy.jdk.labmda;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicatedItems {

    public static void main(String[] args) {
        Cat c1 = new Cat(1, "mimi-1");
        Cat c2 = new Cat(2, "mimi-2");
        Cat c3 = new Cat(3, "mimi-3");
        Cat c4 = new Cat(4, "mimi-4");
        Cat c5 = new Cat(1, "mimi-1");

        List<Cat> catList = new ArrayList<>();
        catList.add(c1);
        catList.add(c2);
        catList.add(c3);
        catList.add(c4);
        catList.add(c5);

        List<Cat> uniques = catList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Cat::getId))), ArrayList::new));
        System.out.println(uniques);

        removingDuplicates();
    }

    private static void removingDuplicates() {
        List<Integer> listWithDuplicates = Arrays.asList(1, 1, 2, 2, 3, 3);
        List<Integer> listWithoutDuplicates = listWithDuplicates.stream().distinct().collect(Collectors.toList());
        System.out.println(listWithoutDuplicates);
    }



    private static class Cat {
        private long id;
        private String name;
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Cat{");
            sb.append("id=").append(id);
            sb.append(", name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
        public Cat(long id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}


