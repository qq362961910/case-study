package com.jy.casestudy.algorithm.search;

import java.util.Arrays;

/**
 * 二分查找法
 *
 * @author <a href="mailto:jian.yang@xman.com">研发部-用户中心组-杨建</a>
 * @version V1.0
 * @since 2020-07-08 08:57
 **/
public class BinarySearchCase {

    public static void main(String[] args) {
        int[] arr= {30,20,50,10,80,9,7,12,100,40,8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(searchIndex(arr, 40));
        System.out.println(searchIndex(arr, 40, 0, arr.length));
    }

    private static int searchIndex(int[] arr, int value) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        int lowIndex = 0;
        int highIndex = arr.length;
        while (lowIndex <= highIndex) {
            int midIndex = (highIndex + lowIndex) / 2;
            if(value == arr[midIndex]) {
                return midIndex;
            } else if(value > arr[midIndex]) {
                lowIndex = midIndex + 1;
            } else{
                highIndex = midIndex - 1;
            }
        }
        return -1;
    }

    private static int searchIndex(int[] arr, int value, int minIndex, int maxIndex) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        int midIndex = (minIndex + maxIndex) / 2;
        if(value == arr[minIndex]) {
            return midIndex;
        } else if(value > arr[minIndex]) {
            return searchIndex(arr, value, midIndex + 1, maxIndex);
        } else {
            return searchIndex(arr, value, minIndex, midIndex - 1);
        }
    }
}
