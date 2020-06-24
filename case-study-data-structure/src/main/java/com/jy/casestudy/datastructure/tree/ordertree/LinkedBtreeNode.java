package com.jy.casestudy.datastructure.tree.ordertree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *  B tree node
 * create: 2019-09-16 14:03
 * @author yj
 **/
public class LinkedBtreeNode<K extends Comparable<K>, V> {

    private static final Logger logger = LoggerFactory.getLogger(LinkedBtreeNode.class);

    private final int m;

    /**
     * 节点数据，按键生序
     * */
    private List<Map.Entry<K, V>> entries = new ArrayList<>();

    private List<LinkedBtreeNode<K, V>> subNodes = new ArrayList<>();

    public LinkedBtreeNode(int m) {
        this.m = m;
    }

    public List<Map.Entry<K, V>> getEntries() {
        return entries;
    }

    public void setEntries(List<Map.Entry<K, V>> entries) {
        this.entries = entries;
    }

    public List<LinkedBtreeNode<K, V>> getSubNodes() {
        return subNodes;
    }

    public void setSubNodes(List<LinkedBtreeNode<K, V>> subNodes) {
        this.subNodes = subNodes;
    }

    public void insert(K k, V v) {
        if (k == null) {
            throw new IllegalArgumentException("key不能为空");
        }
        //空树
        if (entries.size() == 0) {
            entries.add(new AbstractMap.SimpleEntry<>(k, v));
        } else {
            int lastIndex = 0;
            int halfIndex = (entries.size() + 1) / 2 - 1;
            if(halfIndex > 0) {
                Map.Entry<K, V> entry = entries.get(halfIndex);
                K key = entry.getKey();
                if(key == null) {

                } else {
                    if(key.compareTo(k) == 0) {
                        entry.setValue(v);
                    } else if(key.compareTo(k) > 0) {
                        lastIndex = halfIndex;
                        halfIndex = (halfIndex + 1) / 2 - 1;
                    } else {
                        lastIndex = halfIndex;
                        halfIndex += (halfIndex + 1) / 2 + 1;
                    }
                }
            } else {
                logger.error("节点数据不合法");
            }
        }
    }
}
