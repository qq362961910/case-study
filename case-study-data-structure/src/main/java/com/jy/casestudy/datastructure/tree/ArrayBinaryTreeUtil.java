package com.jy.casestudy.datastructure.tree;

import cn.t.util.common.ArrayUtil;
import cn.t.util.common.math.LogarithmUtil;

public class ArrayBinaryTreeUtil {

    /**
     * 随机树
     * create time: 9/10/19
     * @author   yj
     * @param length 节点数量
     */
    public static int[] randomArrayBinaryTree(int length) {
        int[] arr = new int[length];
        for(int i=0; i<length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 是否为完全二叉树
     * create time: 9/10/19
     * @author   yj
     * @param binaryTree 树
     * @param depth depth
     */
    public static boolean isTotalBinaryTree(int[] binaryTree, int depth) {
        return (LogarithmUtil.logDown(binaryTree.length, 2) + 1) == depth;
    }

    /**
     * 计算完全二叉树父节点下标
     * create time: 9/10/19
     * @author   yj
     * @param arr 二叉树
     * @param index 子节点
     */
    public static int calculateTotalBinaryTreeParentNodeIndexByNode(int[] arr, int index) {
        if(ArrayUtil.isEmpty(arr) || index == 0) {
            return -1;
        } else {
            return (index-1)/2;
        }
    }

    /**
     * 判断是否拥有左子节点
     * create time: 9/10/19
     * @author   yj
     * @param arr 二叉树
     * @param index 父节点
     */
    public static boolean hasTotalBinaryTreeLeftChild(int[] arr, int index) {
        return (2 * (index + 1)) <= arr.length;
    }

    /**
     * 判断是否拥有右子节点
     * create time: 9/10/19
     * @author   yj
     * @param arr 二叉树
     * @param index 父节点
     */
    public static boolean hasTotalBinaryTreeRightChild(int[] arr, int index) {
        return (2 * (index + 1)) + 1 <= arr.length;
    }
}
