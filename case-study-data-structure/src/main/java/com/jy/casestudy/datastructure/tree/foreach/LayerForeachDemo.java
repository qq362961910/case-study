package com.jy.casestudy.datastructure.tree.foreach;

import com.jy.casestudy.datastructure.tree.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LayerForeachDemo {
    public static void main(String[] args) {
        BinaryTree tree = buildTree();
        layerForeach(tree);
    }

    public static void layerForeach(BinaryTree tree) {
        BinaryTree.Node root = tree.getRoot();
        LinkedList<BinaryTree.Node> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (linkedList.size() > 0) {
            BinaryTree.Node current = linkedList.poll();
            System.out.println(current.getValue());
            if(current.getLeft() != null) {
                linkedList.add(current.getLeft());
            }
            if(current.getRight() != null) {
                linkedList.add(current.getRight());
            }
        }
    }

    private static BinaryTree buildTree() {
        BinaryTree.Node root = new BinaryTree.Node();
        root.setValue("0");
        List<BinaryTree.Node> rootList = Collections.singletonList(root);

        for (int i=0; i<5; i++) {
            int index = 0;
            List<BinaryTree.Node> newRootList = new ArrayList<>(rootList.size() * 2);
            for(BinaryTree.Node currentRoot: rootList) {
                String leftValue = currentRoot.getValue() + "-" + index++;
                String rightValue = currentRoot.getValue() + "-" + index++;
                BinaryTree.Node left = new BinaryTree.Node();
                left.setValue(leftValue);
                BinaryTree.Node right = new BinaryTree.Node();
                right.setValue(rightValue);
                currentRoot.setLeft(left);
                currentRoot.setRight(right);
                newRootList.add(left);
                newRootList.add(right);
            }
            rootList = newRootList;
        }

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);
        return binaryTree;
    }
}
