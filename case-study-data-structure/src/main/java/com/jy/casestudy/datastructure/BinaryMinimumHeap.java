package com.jy.casestudy.datastructure;


import cn.t.util.common.RandomUtil;

/**
 * 最小堆
 * 1.完全二叉树
 * 2.根结点为最小值
 * 3.任意节点的父节点的值都小于或者等于其左右节点的值
 * */
public class BinaryMinimumHeap {

    /**
     * 下沉调整
     *
     * @param array       待调整的堆
     * @param parentIndex 要下沉的父节点
     * @param length      堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            // 如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            // 如果父节点小于任何一个孩子的值，直接跳出
            if (temp <= array[childIndex]) {
                break;
            }
            //无需真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 构建堆
     *
     * @param array 待调整的堆
     */

    public static void buildHeap(int[] array) {
        // 完全二叉树节点数量 = 2^N(N为输的高度) - 1
        // 从最后一个非叶子节点开始，依次下沉调整
        for (int i = array.length / 2; i >= 0; i--) {
            downAdjust(array, i, array.length - 1);
        }
    }

    /**
     * 输出二叉树
     * @param array xxx
     * @param scale xxx
     */
    public static void printHeap(int[] array, int scale) {
        if (array != null && array.length > 0) {
            String split = ".";
            int len = log(array.length + 1, 2);
            out:
            for (int i = 0; i < len; i++) {
                int last = (int) Math.pow(2, i) - 2;
                //输出数据
                int total = (int) Math.pow(2, i);
                for (int j = 1; j <= total; j++) {
                    for (int k = 0; k < Math.pow(2, len - i) * scale; k++) {
                        System.out.print(split);
                    }
                    if ((last + j) >= array.length) {
                        break;
                    }
                    System.out.print(array[last + j]);
                    int strLen = String.valueOf(array[last + j]).length();
                    for (int k = 0; k < (Math.pow(2, len - i) - 1) * scale + (scale - 1) - (strLen - 1); k++) {
                        System.out.print(split);
                    }
                }
                System.out.println();
            }
        }
    }

    public static void printHeap(int[] array) {
        printHeap(array, 1);
    }

    /**
     * 求指数
     * @param value xxx
     * @param base xxx
     * @return xxx
     */
    public static int log(double value, double base) {
        return (int) Math.ceil(Math.log(value) / Math.log(base));
    }


    public static void main(String[] args) {
        int[] arr = new int[63];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RandomUtil.randomInt(0, 10);
        }
        buildHeap(arr);
        printHeap(arr);
    }


}
