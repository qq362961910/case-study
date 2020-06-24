package com.jy.casestudy.datastructure.tree.test;

import cn.t.util.common.PrintUtil;
import com.jy.casestudy.datastructure.tree.ArrayBinaryTreeUtil;
import com.jy.casestudy.datastructure.tree.LinkedBinaryTreeNode;
import com.jy.casestudy.datastructure.tree.LinkedBinaryTreeUtil;
import org.junit.Test;

/**
 * @author yj
 * @since 2020-06-24 15:59
 **/
public class LinkedBinaryTreeUtilTest {

    @Test
    public void linkedTreeForeach() {
        int[] binaryTree = ArrayBinaryTreeUtil.randomArrayBinaryTree((2 << 4) - 1);
        PrintUtil.printBinaryTree(binaryTree);
        LinkedBinaryTreeNode<Integer> linkedTree = LinkedBinaryTreeUtil.arrayBinaryTreeToLinkedBinaryTree(binaryTree);
        LinkedBinaryTreeUtil.prevOrderForeach(linkedTree);
        System.out.println();
        LinkedBinaryTreeUtil.middleOrderForeach(linkedTree);
        System.out.println();
        LinkedBinaryTreeUtil.backOrderForeach(linkedTree);
    }
}
