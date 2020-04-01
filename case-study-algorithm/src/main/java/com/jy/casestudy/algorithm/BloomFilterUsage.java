package com.jy.casestudy.algorithm;


import cn.t.util.common.Assert;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterUsage {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 10000000, 0.01);
        for (int i = 0; i < 10000000; i++) {
            filter.put(i);
        }
        Assert.isTrue(filter.mightContain(1), "不包含1");
        Assert.isTrue(filter.mightContain(2), "不包含2");
        Assert.isTrue(filter.mightContain(3), "不包含3");
        //集合中未放置该数据应该报错
        Assert.isTrue(filter.mightContain(20000000), "不包含20000000");
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - start));
    }
}
