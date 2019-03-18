package com.jy.util.casestudy.common;

/**
 * 斐波纳契数列
 */
public class Fibonacci {

    public static void main(String[] args) {

        for (int i = 0; i < 40; i++) {
            long recursionStartTime = System.currentTimeMillis();
            int recursionResult = recursionImplementation(i);
            long recursionEndTime = System.currentTimeMillis();
            System.out.println("递归实现: " + recursionResult + ", 总耗时: " + (recursionEndTime - recursionStartTime));

            long forwardPassStartTime = System.currentTimeMillis();
            int forwardPassResult = forwardPassImplementation(i);
            long forwardPassEndTime = System.currentTimeMillis();
            System.out.println("正推法实现: " + forwardPassResult + ", 总耗时: " + (forwardPassEndTime - forwardPassStartTime));

            long generalTermFormulaStartTime = System.currentTimeMillis();
            long generalTermFormulaResult = generalTermFormulaImplementation(i);
            long generalTermFormulaEndTime = System.currentTimeMillis();
            System.out.println("通项公式法实现: " + generalTermFormulaResult + ", 总耗时: " + (generalTermFormulaEndTime - generalTermFormulaStartTime));
            System.out.println("--------------------------------------");
        }

    }

    /**
     * 正推法
     * @param n xxx
     * @return xxx
     */
    public static int forwardPassImplementation(int n) {
        int pre = 0;
        int next = 1;
        if (n == 0) {
            return pre;
        } else if (n == 1) {
            return next;
        } else {
            for (int i = 2; i <= n; i++) {
                int tmp = pre + next;
                pre = next;
                next = tmp;
            }
        }
        return next;
    }


    /**
     * 递归实现
     * @param n xxx
     * @return xxx
     */
    public static int recursionImplementation(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return recursionImplementation(n - 1) + recursionImplementation(n - 2);
    }

    /**
     * 通项公式
     * @param n xxx
     * @return xxx
     */
    public static long generalTermFormulaImplementation(int n) {
        return Math.round(Math.pow(((1 + Math.sqrt(5)) / 2.0), n) / Math.sqrt(5) - Math.pow(((1 - Math.sqrt(5)) / 2.0), n) / Math.sqrt(5));
    }


    /**
     * 矩阵斐波那契实现
     * "https://www.cnblogs.com/huxianglin/p/5995649.html"
     * */

}
