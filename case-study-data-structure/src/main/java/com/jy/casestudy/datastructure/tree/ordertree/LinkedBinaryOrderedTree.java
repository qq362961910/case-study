package com.jy.casestudy.datastructure.tree.ordertree;

/**
 * 二叉搜索树
 * create: 2019-09-10 21:29
 * @author yj
 **/
public class LinkedBinaryOrderedTree<T> {

    /**
     * 根结点
     * */
    private LinkedBinaryOrderedTreeNode<T> root;

    public LinkedBinaryOrderedTree() {
    }

    public LinkedBinaryOrderedTree(LinkedBinaryOrderedTreeNode root) {
        this.root = root;
    }

    public LinkedBinaryOrderedTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(LinkedBinaryOrderedTreeNode<T> root) {
        this.root = root;
    }

    /**
     * 查找一个节点
     * create time: 9/10/19
     * @author   yj
     * @param key ID值
     */
    public LinkedBinaryOrderedTreeNode<T> findByKey(int key) {
        LinkedBinaryOrderedTreeNode<T> current = root;
        while (current != null && current.getId() != key){
            //如果key小于当前节点
            if(key < current.getId()) {
                current = (LinkedBinaryOrderedTreeNode<T>)current.getLeftChild();
                //如果key大于当前节点
            } else {
                current = (LinkedBinaryOrderedTreeNode<T>)current.getRightChild();
            }
        }
        return current;
    }

    /**
     * 插入节点
     * create time: 9/11/19
     * @author   yj
     * @param key ID值
     * @param data 数据
     */
    public void insertOrUpdate(int key, T data) {
        if(root == null) {
            root = new LinkedBinaryOrderedTreeNode<>(key, data);
        } else {
            LinkedBinaryOrderedTreeNode<T> parent = root;
            LinkedBinaryOrderedTreeNode<T> current = root;
            while (true) {
                if(current.getId() > key) {
                    parent = current;
                    current = (LinkedBinaryOrderedTreeNode<T>)current.getLeftChild();
                    if(current == null) {
                        current = new LinkedBinaryOrderedTreeNode<>(key, data);
                        parent.setLeftChild(current);
                        break;
                    }
                } else if(current.getId() == key) {
                    //更新当前节点
                    current.setValue(data);
                    break;
                } else {
                    parent = current;
                    current = (LinkedBinaryOrderedTreeNode<T>)current.getRightChild();
                    if(current == null) {
                        current = new LinkedBinaryOrderedTreeNode<>(key, data);
                        parent.setRightChild(current);
                        break;
                    }
                }
            }
        }
    }

    public void deleteByKey(int key) {
        LinkedBinaryOrderedTreeNode<T> parent = null;
        LinkedBinaryOrderedTreeNode<T> current = root;
        boolean left = true;
        while (current != null && current.getId() != key){
            parent = current;
            //如果key小于当前节点
            if(key < current.getId()) {
                left = true;
                current = (LinkedBinaryOrderedTreeNode<T>)current.getLeftChild();
                //如果key大于当前节点
            } else {
                left = false;
                current = (LinkedBinaryOrderedTreeNode<T>)current.getRightChild();
            }
        }
        if(current != null) {
            //1.没有子节点
            if(current.getLeftChild() == null && current.getRightChild() == null) {
                if(parent == null) {
                    root = null;
                } else {
                    if(left) {
                        parent.setLeftChild(null);
                    } else {
                        parent.setRightChild(null);
                    }
                }
            }
            //2.只有左子节点
            else if(current.getRightChild() == null) {
                if(root == current) {
                    root = (LinkedBinaryOrderedTreeNode<T>)root.getLeftChild();
                } else {
                    if(left) {
                        parent.setLeftChild(current.getLeftChild());
                    } else {
                        parent.setRightChild(current.getLeftChild());
                    }
                }
            }
            //3.只有右子节点
            else if(current.getLeftChild() == null) {
                if(root == current) {
                    root = (LinkedBinaryOrderedTreeNode<T>)root.getRightChild();
                } else {
                    if(left) {
                        parent.setLeftChild(current.getRightChild());parent.setLeftChild(current.getRightChild());
                    } else {
                        parent.setRightChild(current.getRightChild());
                    }
                }
            }
            //4.有两个子节点
            else {
                LinkedBinaryOrderedTreeNode<T> nextSiblingParent = current;
                LinkedBinaryOrderedTreeNode<T> nextSiblingNode = (LinkedBinaryOrderedTreeNode<T>)current.getRightChild();
                LinkedBinaryOrderedTreeNode<T> leftest = (LinkedBinaryOrderedTreeNode<T>)nextSiblingNode.getLeftChild();
                while (leftest != null) {
                    nextSiblingParent = nextSiblingNode;
                    nextSiblingNode = leftest;
                    leftest = (LinkedBinaryOrderedTreeNode<T>)leftest.getLeftChild();
                }
                if(left) {
                    parent.setLeftChild(nextSiblingNode);
                } else {
                    parent.setRightChild(nextSiblingNode);
                }
                nextSiblingNode.setLeftChild(current.getLeftChild());
                if(current.getRightChild() != nextSiblingNode) {
                    nextSiblingNode.setRightChild(current.getRightChild());
                }
                nextSiblingParent.setLeftChild(null);
            }
        }
    }

}
