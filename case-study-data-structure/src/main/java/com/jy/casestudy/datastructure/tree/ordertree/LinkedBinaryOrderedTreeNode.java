package cn.t.util.casestudy.tree.ordertree;

import cn.t.util.casestudy.tree.LinkedBinaryTreeNode;

/**
 * @description: 二叉搜索树节点
 * create: 2019-09-10 21:25
 * @author: yj
 **/
public class LinkedBinaryOrderedTreeNode<T> extends LinkedBinaryTreeNode<T> {

    /**
     * 关键字/索引（识别数据用）
     * */
    private int id;

    public LinkedBinaryOrderedTreeNode(int id, T data) {
        super(data);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Node [id=" + id + ", data=" + getValue() + ", leftChild=" + getLeftChild() + ", rightChild=" + getRightChild() + "]";
    }
}
