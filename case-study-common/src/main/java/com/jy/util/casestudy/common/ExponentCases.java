package com.jy.util.casestudy.common;

public class ExponentCases {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (is2Exponent(i)) {
                System.out.println(i + "是2的次幂");
            }
        }
    }

    /**
     * 判断一个数是否为2的n次幂
     */
    private static boolean is2Exponent(int number) {
        return (number & (number - 1)) == 0;
    }
}
