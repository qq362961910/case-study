package com.jy.util.casestudy.common;


import cn.t.util.common.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小值栈
 */
public class MinValueStack {

    private static final Logger logger = LoggerFactory.getLogger(MinValueStack.class);

    private List<Integer> data = new ArrayList<>();
    //按从大到小的顺序排列
    private List<Integer> mins = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        int[] numbers = new int[7];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = RandomUtil.randomInt(0, 100);
        }

        MinValueStack minValueStack = new MinValueStack();
        for (int i = 0; i < numbers.length; i++) {
            minValueStack.push(numbers[i]);
        }

        logger.info("values: {}", minValueStack.data);
        logger.info("mins: {}", minValueStack.mins);

        for (int i = 0; i < numbers.length; i++) {
            minValueStack.pop();
            logger.info("values: {}", minValueStack.data);
            logger.info("mins: {}", minValueStack.mins);
        }
    }

    public void push(int num) throws Exception {
        data.add(num);
        if (mins.size() == 0) {
            // 初始化mins
            mins.add(0);
        } else {
            // 辅助栈mins push最小值的索引
            int min = getMin();
            if (num < min) {
                mins.add(data.size() - 1);
            }
        }
    }

    public int pop() throws Exception {
        // 栈空，抛出异常
        if (data.size() == 0) {
            throw new Exception("stack is empty");
        }
        // pop时先获取索引
        int popIndex = data.size() - 1;
        // 获取mins栈顶元素，它是最小值索引
        int minIndex = mins.get(mins.size() - 1);
        // 如果pop出去的索引就是最小值索引，mins才出栈
        if (popIndex == minIndex) {
            mins.remove(mins.size() - 1);
        }
        return data.remove(data.size() - 1);
    }

    public int getMin() throws Exception {
        // 栈空，抛出异常
        if (data.size() == 0) {
            throw new Exception("stack is empty");
        }
        // 获取mins栈顶元素，它是最小值索引
        int minIndex = mins.get(mins.size() - 1);
        return data.get(minIndex);
    }
}
