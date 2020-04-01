package com.jy.casestudy.algorithm;

/**
 * 互换赋值
 *
 * @author yj
 * @since 2020-04-01 19:03
 **/
public class ExchangeValue {

    public static void main(String[] args) {
        exchangeM1();
        exchangeM2();
        exchangeM3();
    }

    /**
     * 利用第三个变量交换数值
     */
    private static void exchangeM1() {
        int x =5;
        int y=10;

        //定义第三临时变量temp并提取x值
        int temp = x;
        //把y的值赋给x
        x = y;
        //然后把临时变量temp值赋给y
        y = temp;
        System.out.println("x="+x+", y="+y);
    }

    /**
     * 两个数求和然后相减的方式进行数据交换,弊端在于如果 x 和 y 的数值过大的话，超出 int 的值会损失精度
     */
    private static void exchangeM2() {
        int x =5;
        int y=10;

        //x(15) = 5 + 10；
        x = x + y;

        //y(5) = x(15) - 10;
        y = x - y;

        //x(10) = x(15) - y(5)
        x = x - y;
        System.out.println("x="+x+", y="+y);
    }

    /**
     * 位运算的方式进行数据的交换，利用的思想原理是：一个数异或同一个数两次，结果还是那个数，(一个数亦或自己一定为0, 0亦或自己还是自己), 而且不会超出int范围
     *
     */
    private static void exchangeM3() {
        int x =5;
        int y=10;

        x = x ^ y;

        //y = (x ^ y) ^ y
        y = x ^ y;
        //x = (x ^ y) ^ x --> x ^ x ^ y --> 0 ^ y = y
        x = x ^ y;

        System.out.println("x="+x+", y="+y);
    }
}
