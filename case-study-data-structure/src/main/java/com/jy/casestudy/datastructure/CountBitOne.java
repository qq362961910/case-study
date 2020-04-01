package com.jy.casestudy.datastructure;

/**
 * 数二进制当中包含多少个1
 * */
public class CountBitOne {

    public static void main(String[] args) {
        //expect count: 20
        System.out.println("offsetCount: " + offsetCount(1048575));
        System.out.println("offsetCount: " + andOperatorCount(1048575));

    }


    /**
     * 分析：不管n的二进制表示里包含多少个1，都需要循环计算32次，比较耗时。有没有可能，每次消除掉一个1，这样来降低计算次数呢？
     */
    private static int offsetCount(int number) {
        int count = number & 1;
        for (int i = 1; i < 32; i++) {
            if (((number >>= 1) & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * 观察一下n与n-1这两个数的二进制表示：
     * 1.最末位一个1会变成0
     * 2.最末位一个1之后的0会全部变成1
     * 3.其他位相同
     * 栗子：
     * x = 1011 0000
     * x-1= 1010 1111
     * x & (x-1) = 1010 0000
     * 于是，n&(n-1)这个操作，可以起到“消除最后一个1”的功效。
     * 分析：这个方法，n的二进制表示有多少个1，就会计算多少次。总的来说，n的长度是32bit，如果n的值选取完全随机，平均期望由16个1构成，平均下来16次，节省一半的计算量。
     */
    private static int andOperatorCount(int number) {
        int count = 0;
        while (number != 0) {
            number &= (number - 1);
            count++;
        }
        return count;
    }

}
