package com.jy.casestudy.datastructure.tree;

public class BinaryTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
            "root=" + root +
            '}';
    }

    public static class Node {
        private String value;
        private Node left;
        private Node right;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                "value='" + value + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
        }
    }
}
