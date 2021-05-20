package com.jy.casestudy.jdk.labmda;

import cn.t.util.common.JsonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class MapUsage {

    public static void main(String[] args) throws Exception {

//        List<String> strList = Stream.of("a", "b")
//            .map(String::toUpperCase)
//            .collect(Collectors.toList());
//        System.out.println(strList);
//
//
//        List<Dog> dogList = Stream.of("a", "b")
//            .map(Dog::new)
//            .collect(Collectors.toList());
//        System.out.println(dogList);
        splitList();
    }

    private static class Dog {
        private String name;
        Dog(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "dog: " + name;
        }
    }

    public static void splitList() throws Exception {
        List<Item> response = new ArrayList<>();
        response.add(new Item("云生活", "漫50减5"));
        response.add(new Item("云生活", "漫60减10"));

        response.add(new Item("E健康", "直减5元"));
        response.add(new Item("E健康", "直减10"));
        Map<String, List<Item>> itemMap = response.stream().collect(Collectors.groupingBy(Item::getMerchantName));

        System.out.println(JsonUtil.serialize(itemMap));
    }

    private static class Item {
        private String merchantName;
        private String couponName;

        public String getMerchantName() {
            return merchantName;
        }

        public void setMerchantName(String merchantName) {
            this.merchantName = merchantName;
        }

        public String getCouponName() {
            return couponName;
        }

        public void setCouponName(String couponName) {
            this.couponName = couponName;
        }

        public Item(String merchantName, String couponName) {
            this.merchantName = merchantName;
            this.couponName = couponName;
        }

        @Override
        public String toString() {
            return "Item{" +
                "merchantName='" + merchantName + '\'' +
                ", couponName='" + couponName + '\'' +
                '}';
        }
    }

}


