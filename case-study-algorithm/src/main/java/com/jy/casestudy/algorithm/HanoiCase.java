package com.jy.casestudy.algorithm;

/**
 * 汉娜塔
 */
public class HanoiCase {

    public static void main(String[] args) {
        transfer(5, 'A', 'B', 'C');
    }

    //将n个盘子,从from移到to,中间借助temp
    static void transfer(int n, char from, char to, char temp) {
        if (n == 0) return;

        //将n-1个盘子,从from移到temp,中间借助to
        transfer(n - 1, from, temp, to);

        //将最大的盘子从from移到to
        System.out.println(from + " ----> " + to);

        //将n-1个盘子,从temp移到to,中间借助from
        transfer(n - 1, temp, to, from);

    }
}
