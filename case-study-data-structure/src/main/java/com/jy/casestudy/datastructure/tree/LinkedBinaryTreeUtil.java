package cn.t.util.casestudy.tree;

import cn.t.util.casestudy.tree.ordertree.LinkedBinaryOrderedTreeNode;
import cn.t.util.common.ArrayUtil;
import cn.t.util.common.CollectionUtil;

import java.util.*;

/**
 * 二叉树工具类
 * @author yj
 * create: 2019-09-09 14:16
 **/
public class LinkedBinaryTreeUtil {

    public static Integer[] linkedTreeToArrayBinaryTree(LinkedBinaryTreeNode<Integer> root) {
        if(root == null) {
            return new Integer[0];
        } else {
            int depth = treeDepth(root);
            int nodes = (int)Math.pow(2, depth) - 1;
            return linkedTreeToArrayBinaryTree(root, 0, new Integer[nodes]);
        }
    }

    private static<T> T[] linkedTreeToArrayBinaryTree(LinkedBinaryTreeNode<T> node, int index, T[] arr) {
        if(node != null) {
            arr[index] = node.getValue();
            linkedTreeToArrayBinaryTree(node.getLeftChild(), 2 * (index + 1) - 1, arr);
            linkedTreeToArrayBinaryTree(node.getRightChild(), 2 * (index + 1), arr);
        }
        return arr;
    }

    public static <T> int[] linkedOrderTreeToArrayBinaryTree(LinkedBinaryOrderedTreeNode<T> root) {
        if(root == null) {
            return new int[0];
        } else {
            int depth = treeDepth(root);
            int nodes = (int)Math.pow(2, depth) - 1;
            return linkedOrderTreeToArrayBinaryTree(root, 0, new int[nodes]);
        }
    }

    private static<T> int[] linkedOrderTreeToArrayBinaryTree(LinkedBinaryOrderedTreeNode<T> node, int index, int[] arr) {
        if(node != null) {
            arr[index] = node.getId();
            linkedOrderTreeToArrayBinaryTree((LinkedBinaryOrderedTreeNode<T>)node.getLeftChild(), 2 * (index + 1) - 1, arr);
            linkedOrderTreeToArrayBinaryTree((LinkedBinaryOrderedTreeNode<T>)node.getRightChild(), 2 * (index + 1), arr);
        }
        return arr;
    }

    public static LinkedBinaryTreeNode<Integer> arrayBinaryTreeToLinkedBinaryTree(int[] arr) {
        if(!ArrayUtil.isEmpty(arr)) {
            return randomLinkedBinaryTree(arr, 0);
        } else {
            return null;
        }
    }

    private static LinkedBinaryTreeNode<Integer> randomLinkedBinaryTree(int[] arr, int indexSrc) {
        LinkedBinaryTreeNode<Integer> root = new LinkedBinaryTreeNode<>(arr[indexSrc++]);
        List<LinkedBinaryTreeNode<Integer>> linkedBinaryTreeNodes = new ArrayList<>(1);
        linkedBinaryTreeNodes.add(root);
        randomLinkedBinaryTree(linkedBinaryTreeNodes, arr, indexSrc);
        return root;
    }

    private static void randomLinkedBinaryTree(List<LinkedBinaryTreeNode<Integer>> parentNodes, int[] arr, int indexSrc) {
        List<LinkedBinaryTreeNode<Integer>> newParentNodes = new ArrayList<>( parentNodes.size() * 2);
        for(int i=0; i<parentNodes.size() && indexSrc < arr.length; i++) {
            LinkedBinaryTreeNode<Integer> nodeL = new LinkedBinaryTreeNode<>(arr[indexSrc++]);
            newParentNodes.add(nodeL);
            parentNodes.get(i).addLeft(nodeL);
            if(indexSrc < arr.length) {
                LinkedBinaryTreeNode<Integer> nodeR = new LinkedBinaryTreeNode<>(arr[indexSrc++]);
                newParentNodes.add(nodeR);
                parentNodes.get(i).addRight(nodeR);
            } else {
                break;
            }
        }
        if(indexSrc == arr.length) {
            return;
        }
        randomLinkedBinaryTree(newParentNodes, arr, indexSrc);
    }

    /**
     * @description: 计算树中节点个数
     * create time: 9/9/19
     * @author:   yj
     * @param root 根节点
     */
    public static <T> int countTreeNodes(LinkedBinaryTreeNode<T> root) {
        if(root == null) {
            return 0;
        }
        return countTreeNodes(root.getLeftChild()) + countTreeNodes(root.getRightChild()) + 1;
    }

    /**
     * @description: 计算树的深度
     * create time: 9/9/19
     * @author:   yj
     * @param root 根节点
     */
    public static <T> int treeDepth(LinkedBinaryTreeNode<T> root) {
        if(root == null) {
            return 0;
        }
        return Math.max(treeDepth(root.getLeftChild()), treeDepth(root.getRightChild())) + 1;
    }


    /**
     * @description: 前序遍历
     * create time: 9/9/19
     * @author:   yj
     * @param root 根节点
     */
    public static <T> void prevOrderForeach(LinkedBinaryTreeNode<T> root) {
        if(root != null) {
            visitNode(root);
            prevOrderForeach(root.getLeftChild());
            prevOrderForeach(root.getRightChild());
        }

    }

    /**
     * @description: 中序遍历
     * create time: 9/9/19
     * @author:   yj
     * @param root 根节点
     */
    public static <T> void middleOrderForeach(LinkedBinaryTreeNode<T> root) {
        if(root != null) {
            middleOrderForeach(root.getLeftChild());
            visitNode(root);
            middleOrderForeach(root.getRightChild());
        }
    }

    /**
     * @description: 后序遍历
     * create time: 9/9/19
     * @author:   yj
     * @param root 根节点
     */
    public static <T> void backOrderForeach(LinkedBinaryTreeNode<T> root) {
        if(root != null) {
            backOrderForeach(root.getLeftChild());
            backOrderForeach(root.getRightChild());
            visitNode(root);
        }

    }

    /**
     * @description: 分层遍历
     * create time: 9/9/19
     * @author:   yj
     * @param root 根节点
     */
    public static <T> void layerForeach(LinkedBinaryTreeNode<T> root) {
        if(root != null) {
            Queue<LinkedBinaryTreeNode<T>> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                LinkedBinaryTreeNode<T> tmp = queue.poll();
                visitNode(tmp);
                if(tmp.getLeftChild() != null) {
                    queue.offer(tmp.getLeftChild());
                }
                if(tmp.getRightChild() != null) {
                    queue.offer(tmp.getRightChild());
                }
            }
        }
    }

    /**
     * @description: 访问node节点
     * create time: 9/9/19
     * @author:   yj
     * @param node 节点
     */
    private static <T> void visitNode(LinkedBinaryTreeNode<T> node) {
        System.out.print(node.getValue() + "\t");
    }

    /**
     * @description: default
     * create time: 9/9/19
     * @author:   yj
     * @param root 根节点
     * @param layer 树的深度
     */
    public static <T> int countLayerNodes(LinkedBinaryTreeNode<T> root, int layer) {
        if(root == null || layer < 1) {
            return 0;
        }
        if(layer == 1) {
            return 1;
        }
        int leftCount = countLayerNodes(root.getLeftChild(), layer - 1);
        int rightCount = countLayerNodes(root.getRightChild(), layer - 1);
        return leftCount + rightCount;
    }

    /**
     * @description: 求二叉树中叶子节点的个数
     * create time: 9/9/19
     * @author:   yj
     * @param root 根节点
     */
    public static <T> int countLeaf(LinkedBinaryTreeNode<T> root) {
        if(root == null) {
            return 0;
        }
        if(root.getLeftChild() == null && root.getRightChild() == null) {
            return 1;
        }
        int leftCount = countLeaf(root.getLeftChild());
        int rightCount = countLeaf(root.getRightChild());
        return leftCount + rightCount;
    }

    /**
     * @description: default
     * create time: 9/9/19
     * @author:   yj
     * @param root 根节点
     */
    public static <T> void exchange(LinkedBinaryTreeNode<T> root) {
        if(root != null) {
            exchange(root.getLeftChild());
            exchange(root.getRightChild());
            LinkedBinaryTreeNode<T> tmp = root.getLeftChild();
            root.setLeftChild(root.getRightChild());
            root.setRightChild(tmp);
        }
    }

    /**
     * @description: 查看node是否是root的子节点
     * create time: 9/9/19
     * @author:   yj
     * @param root 根节点
     * @param node 子节点
     */
    public static <T> boolean nodeIsChild(LinkedBinaryTreeNode<T> root, LinkedBinaryTreeNode<T> node) {
        if(root == null || node == null) {
            return false;
        }
        if(root == node) {
            return true;
        }
        boolean find = nodeIsChild(root.getLeftChild(), node);
        if(!find) {
            find = nodeIsChild(root.getRightChild(), node);
        }
        return find;
    }


    /**
     * @description: default
     * create time: 9/9/19
     * @author:   yj
     * @param root 根节点
     * @param firstNode 子节点1
     * @param secondNode 子节点2
     */
    public static <T> LinkedBinaryTreeNode findSameParentNode(LinkedBinaryTreeNode<T> root, LinkedBinaryTreeNode<T> firstNode, LinkedBinaryTreeNode<T> secondNode) {
        if(firstNode == root || secondNode == root) {
            return root;
        }
        if(root == null || firstNode == null || secondNode == null) {
            return null;
        }
        //first node 是左节点
        if(nodeIsChild(root.getLeftChild(), firstNode)) {
            if(nodeIsChild(root.getRightChild(), secondNode)) {
                return root;
            } else {
                return findSameParentNode(root.getLeftChild(), firstNode, secondNode);
            }
        } else {
            if(nodeIsChild(root.getLeftChild(), secondNode)) {
                return root;
            } else {
                return findSameParentNode(root.getRightChild(), firstNode, secondNode);
            }
        }
    }

    /**
     * @description: 根据前序和中序构建二叉树
     * create time: 9/10/19
     * @author:   yj
     * @param pre 前序序列
     * @param mid 中序序列
     */
    public static <T> LinkedBinaryTreeNode<T> buildTreeByPreAndMidOrder(List<T> pre, List<T> mid) {
        if(CollectionUtil.isEmpty(pre) || CollectionUtil.isEmpty(mid)) {
            return null;
        }
        if(pre.size() == 1) {
            return new LinkedBinaryTreeNode<>(pre.get(0));
        }
        LinkedBinaryTreeNode<T> root = new LinkedBinaryTreeNode<>(pre.get(0));
        int index = -1;
        //找出根结点在中序中的位置
        while (!pre.get(0).equals(mid.get(++index)));
        List<T> leftPre = new ArrayList<>(index+1);
        List<T> leftMid = new ArrayList<>(leftPre.size());
        for(int i=1; i<=index; i++) {
            leftPre.add(pre.get(i));
        }
        for(int i=0; i<index; i++) {
            leftMid.add(mid.get(i));
        }

        //重构左子树
        LinkedBinaryTreeNode<T> leftNode = buildTreeByPreAndMidOrder(leftPre, leftMid);
        root.setLeftChild(leftNode);

        List<T> rightPre = new ArrayList<>(pre.size() - index - 1);
        List<T> rightMid = new ArrayList<>(rightPre.size());
        for(int i=(index+1); i<pre.size(); i++) {
            rightPre.add(pre.get(i));
            rightMid.add(mid.get(i));
        }

        //重构右子树
        LinkedBinaryTreeNode<T> rightNode = buildTreeByPreAndMidOrder(rightPre, rightMid);
        root.setRightChild(rightNode);

        return root;
    }

    /**
     * @description: 查看两棵树是否相等(两棵树所有节点都相等)
     * create time: 9/10/19
     * @author:   yj
     * @param tree1 树1
     * @param tree2 树2
     */
    public static <T> boolean treeEquals(LinkedBinaryTreeNode<T> tree1, LinkedBinaryTreeNode<T> tree2) {
        if(tree1 == null && tree2 == null) {
            return true;
        } else if(tree1 == null || tree2 == null) {
            return false;
        }
        boolean equal = Objects.equals(tree1.getValue(), tree2.getValue());
        boolean lEqual = treeEquals(tree1.getLeftChild(), tree2.getLeftChild());
        boolean rEqual = treeEquals(tree1.getRightChild(), tree2.getRightChild());
        return equal && lEqual && rEqual;
    }

}
