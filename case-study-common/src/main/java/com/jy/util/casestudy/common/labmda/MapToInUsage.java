package com.jy.util.casestudy.common.labmda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapToInUsage {

    public void mapToIntList() {
        class Dog {
            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Dog(int id, String name) {
                this.id = id;
                this.name = name;
            }
        }

        Dog dog1 = new Dog(1, "a");
        Dog dog2 = new Dog(2, "b");
        Dog dog3 = new Dog(3, "c");

        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);

        System.out.println(dogs.stream().mapToInt(Dog::getId).boxed().collect(Collectors.toList()));
    }


}
