package com.jy.casestudy.jdk.labmda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FilterUsage {

    public static void main(String[] args) {
        List<Instance> strList = new ArrayList<>();
        strList.add(new Instance("1"));
        strList.add(new Instance("2"));
        strList.add(new Instance("3"));
        strList.add(new Instance("4"));
        strList.add(new Instance("5"));
        strList.add(new Instance("6"));
        strList.add(new Instance("7"));

        Instance instance = strList.stream().filter(i -> i.equals(new Instance("1"))).findAny().orElse(null);
        System.out.println(instance);
    }



    private static class Instance {
        private String name;
        @Override
        public boolean equals(Object o) {
            System.out.println("equals run");
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Instance instance = (Instance) o;
            return Objects.equals(name, instance.name);
        }
        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
        private Instance(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Instance{" +
                "name='" + name + '\'' +
                '}';
        }
    }
}


