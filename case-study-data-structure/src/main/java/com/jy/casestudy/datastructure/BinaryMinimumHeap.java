package com.jy.casestudy.datastructure;


import cn.t.util.common.PrintUtil;
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
            downAdjust(array, i, array.length);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[63];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RandomUtil.randomInt(0, 10);
        }
        buildHeap(arr);
        PrintUtil.printBinaryTree(arr);
    }


}
