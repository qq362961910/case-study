package com.jy.util.casestudy.common;


import cn.t.util.common.RandomUtil;

import java.util.Arrays;

/**
 * 选择排序
 * 外层循环控制当前排序的索引
 * 内层循环生于的要与外层循环进行对比的数据，判断是否与外层循环索引的数据进行交换
 */
public class SelectionSort {


    private static void sortMaxHead(int[] arr) {
        if (arr != null && arr.length > 1) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int k = i + 1; k < arr.length; k++) {
                    if (arr[i] < arr[k]) {
                        int tmp = arr[i];
                        arr[i] = arr[k];
                        arr[k] = tmp;
                    }
                }
            }
        }
    }

    private static void sortSmallHead(int[] arr) {
        if (arr != null && arr.length > 1) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int k = i + 1; k < arr.length; k++) {
                    if (arr[i] > arr[k]) {
                        int tmp = arr[i];
                        arr[i] = arr[k];
                        arr[k] = tmp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RandomUtil.randomInt(0, 20);
        }
        System.out.println("原始数组: " + Arrays.toString(arr));
        sortMaxHead(arr);
        System.out.println("从大到小排序: " + Arrays.toString(arr));
        sortSmallHead(arr);
        System.out.println("从小到大排序: " + Arrays.toString(arr));
    }

}
