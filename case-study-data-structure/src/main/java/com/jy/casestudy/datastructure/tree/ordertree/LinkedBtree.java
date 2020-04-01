package cn.t.util.casestudy.tree.ordertree;

/**
 * @description: B tree，多路平衡查找树
 * create: 2019-09-16 14:08
 * @author: yj
 *
 * @see <a href="https://www.cnblogs.com/nullzx/p/8729425.html>https://www.cnblogs.com/nullzx/p/8729425.html</a>
 **/
public class LinkedBtree<K extends Comparable, V> {

    private static final int M = 4;

    private LinkedBtreeNode<K, V> root;

    public LinkedBtree() {
    }

    public LinkedBtree(LinkedBtreeNode root) {
        this.root = root;
    }

}
