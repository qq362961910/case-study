package com.jy.casestudy.algorithm.sort;



import cn.t.util.common.RandomUtil;

import java.util.Arrays;

/**
 *
 * 冒泡排序
 * 外层循环控制排序趟数
 * 内层循环控制每一趟排序多少次,把没有排序的从后往前，由大到小排列
 */
public class BubbleSortCase {

    private static void sort(int[] arr) {
        if (arr != null && arr.length > 1) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int k = 0; k < arr.length - 1 - i; k++) {
                    if (arr[k] > arr[k + 1]) {
                        int tmp = arr[k];
                        arr[k] = arr[k + 1];
                        arr[k + 1] = tmp;
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
        sort(arr);
        System.out.println("冒泡排序排序: " + Arrays.toString(arr));
    }

}
