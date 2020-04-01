package cn.t.util.casestudy.tree;

import java.util.Objects;

public class LinkedBinaryTreeNode<T> {

    /**
     * 值
     * */
    private T value;

    /**
     * 左子节点
     * */
    private LinkedBinaryTreeNode<T> leftChild;

    /**
     * 右子节点
     * */
    private LinkedBinaryTreeNode<T> rightChild;

    public LinkedBinaryTreeNode() {
    }

    public LinkedBinaryTreeNode(T value) {
        this.value = value;
    }


    /**
     * 增加左子节点
     * create time: 9/9/19
     * @author yj
     * @param value &#x503c;
     */
    public void addLeft(T value) {
        this.leftChild = new LinkedBinaryTreeNode<>(value);
    }

    public void addLeft(LinkedBinaryTreeNode<T> node) {
        this.leftChild = node;
    }
    
    /**
     *  增加右子节点
     * create time: 9/9/19
     * @author  yj
     * @param value 值
     */
    public void addRight(T value) {
        this.leftChild = new LinkedBinaryTreeNode<>(value);
    }

    public void addRight(LinkedBinaryTreeNode<T> node) {
        this.rightChild = node;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedBinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(LinkedBinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public LinkedBinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(LinkedBinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof LinkedBinaryTreeNode)){
            return false;
        }
        return Objects.equals(this.value, ((LinkedBinaryTreeNode) obj).value);
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public String toString(){
        return this.value == null ? "" : this.value.toString();
    }

}
