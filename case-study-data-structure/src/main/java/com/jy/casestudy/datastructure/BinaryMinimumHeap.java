package com.jy.casestudy.datastructure;


import cn.t.util.common.PrintUtil;
import cn.t.util.common.RandomUtil;

import java.util.Arrays;

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
     * @param length   有效长度
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            // 如果有右子节点，且右孩子小于左子节点的值，则定位到右子节点
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            // 如果父节点小于任何一个孩子的值，直接跳出
            if (temp <= array[childIndex]) {
                break;
            }
            //无需真正交换，单向赋值即可, temp存储的是正在被交换的较大的值
            array[parentIndex] = array[childIndex];
            //被移动的子节点重新排序父节点
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }
    public static void downAdjustRecursive(int[] array, int parentIndex, int length) {
        int childIndex = 2 * parentIndex + 1;
        if(childIndex >= length) {
            return;
        }
        int nextIndex = childIndex + 1;
        if(nextIndex < length && array[nextIndex] < array[childIndex]) {
            childIndex = nextIndex;
        }
        if(array[parentIndex] < array[childIndex]) {
            return;
        }
        //值互换, 递归被替换的子节点
        array[parentIndex] ^= array[childIndex];
        array[childIndex] ^= array[parentIndex];
        array[parentIndex] ^= array[childIndex];

        downAdjustRecursive(array, childIndex, length);
    }

    /**
     * 构建堆
     *
     * @param array 待调整的堆
     */

    public static void buildHeap(int[] array) {
        // 完全二叉树节点数量 = 2^N(N为输的高度) - 1
        // 左孩子节点下标: 2 * parentIndex + 1
        // 右孩子节点下标: 2 * parentIndex + 2
        // 假设树的深度为6，完全二叉树共63个节点, 压轴节点为61(2 * parentIndex + 1), 最后一个节点的索引为62(2 * parentIndex + 2), 其父节点索引为30
        // 观察二叉树可以得出结论在节点数量大于1的二叉树中最后一个节点一定是子节点，但不确定是左子节点还是右子节点，首先假设其为左子节点，带入公式
        // array.length - 1 = 2 * parentIndex + 1
        // array.length - 1 - 1 = 2 * parentIndex
        // array.length - 2
        // ---------------- = parentIndex
        //         2
        //假设最后一个节点为右子节点，根据上面计算得出结果:
        // array.length - 3
        // ---------------- = parentIndex
        //         2
        // 由于整数除法计算的特性，可以看出【左子节点的计算适用于右子节点】
        // 从最后一个非叶子节点开始，依次下沉调整
        for (int i = ((array.length-2) / 2); i >= 0; i--) {
//            downAdjust(array, i, array.length);
            downAdjustRecursive(array, i, array.length);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[63];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RandomUtil.randomInt(0, 9);
        }
        System.out.println(Arrays.toString(arr));
//        int[] arr = IntUtil.stringsToInts("0, 6, 3, 0, 6, 4, 5, 6, 5, 6, 2, 1, 6, 5, 4, 2, 4, 2, 1, 4, 5, 8, 0, 5, 2, 5, 0, 1, 0, 1, 1, 7, 5, 7, 1, 8, 0, 1, 7, 2, 2, 3, 3, 5, 1, 5, 1, 6, 5, 3, 0, 8, 0, 7, 4, 8, 2, 1, 2, 1, 5, 5, 2", ",");
        //打印原始的数组
        int [] tempArr = Arrays.copyOf(arr, arr.length - 1);
        Arrays.sort(tempArr);
        System.out.println(Arrays.toString(tempArr));
        System.out.println("====================================================================================================");
        buildHeap(arr);
        PrintUtil.printBinaryTree(arr);
        System.out.println("====================================================================================================");
        //打印整理后的数组
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
