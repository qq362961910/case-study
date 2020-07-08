package com.jy.casestudy.algorithm;

import java.util.*;

/**
 * 一致性hash
 *
 * @author yj
 * @since 2019-12-28 18:59
 **/
public class ConsistentHashCase {

    //物理节点
    private final Set<String> physicalNodes = new TreeSet<>();
    //虚拟节点倍数
    private final int VIRTUAL_MULTIPLE = 32;
    //虚拟节点
    private TreeMap<Long, String> virtualNodes = new TreeMap<>();

    // 32位的 Fowler-Noll-Vo 哈希算法
    // https://en.wikipedia.org/wiki/Fowler–Noll–Vo_hash_function
    private static Long FnvHash(String key) {
        final int p = 16777619;
        long hash = 2166136261L;
        for (int idx = 0, num = key.length(); idx < num; ++idx) {
            hash = (hash ^ key.charAt(idx)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    private String buildVirtualNodeIp(String nodeIp, int index) {
        return nodeIp + "#" + index;
    }

    //添加物理节点
    private void addPhysicalNode(String nodeIp) {
        for(int i=0; i<VIRTUAL_MULTIPLE; i++) {
            Long hash = FnvHash(buildVirtualNodeIp(nodeIp, i));
            virtualNodes.put(hash, nodeIp);
        }
    }

    //删除物理节点
    private void removePhysicalNode(String nodeIp) {
        for(int i=0; i<VIRTUAL_MULTIPLE; i++) {
            Long hash = FnvHash(buildVirtualNodeIp(nodeIp, i));
            virtualNodes.remove(hash);
        }
    }

    //查找对象映射节点
    private String getObjectNode(String object) {
        Long hash = FnvHash(object);
        SortedMap<Long, String> tailMap = virtualNodes.tailMap(hash);
        Long key = tailMap.isEmpty() ? virtualNodes.firstKey() : tailMap.firstKey();
        return virtualNodes.get(key);
    }

    //统计对象与节点的映射关系
    private void dumpObjectNodeMapping(String label, int objectMin, int objectMax) {
        //统计 IP => COUNT
        Map<String, Integer> objectNodeMap = new TreeMap<>();
        for(int object = objectMin; object < objectMax; object++) {
            String nodeIp = getObjectNode(String.valueOf(object));
            Integer count = objectNodeMap.get(nodeIp);
            objectNodeMap.put(nodeIp, count==null ? 1 : count + 1);
        }
        //打印
        long totalCount = objectMax - objectMin + 1;
        System.out.println("=======================" + label + "=======================");
        for(Map.Entry<String, Integer> entry: objectNodeMap.entrySet()) {
            long percent = (entry.getValue() * 100) / totalCount;
            System.out.println("IP=" + entry.getKey() + ":RATE=" + percent + "%");
        }
    }

    private void init() {
        for (String nodeIp : physicalNodes) {
            addPhysicalNode(nodeIp);
        }
    }

    public static void main(String[] args) {
        ConsistentHashCase ch = new ConsistentHashCase();
        ch.addPhysicalNode("192.168.1.101");
        ch.addPhysicalNode("192.168.1.102");
        ch.addPhysicalNode("192.168.1.103");
        ch.addPhysicalNode("192.168.1.104");
        ch.init();

        //初始情况
        ch.dumpObjectNodeMapping("初始情况", 0, 65536);

        //删除物理节点
        ch.removePhysicalNode("192.168.1.103");
        ch.dumpObjectNodeMapping("删除物理节点", 0, 65536);

        //添加物理节点
        ch.addPhysicalNode("192.168.1.108");
        ch.dumpObjectNodeMapping("添加物理节点", 0, 65536);
    }

}
