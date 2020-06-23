package com.jy.casestudy.datastructure;


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

    //存放所有值
    private final List<Integer> data = new ArrayList<>();
    //按从大到小的顺序排列存放值下标
    private final List<Integer> minIndexList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        //随机产生一批数字
        int[] numbers = new int[20];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = RandomUtil.randomInt(0, 100);
        }

        //压数据进栈
        MinValueStack minValueStack = new MinValueStack();
        for (int number : numbers) {
            minValueStack.push(number);
        }

        logger.info("values: {}", minValueStack.data);
        logger.info("minIndexList: {}", minValueStack.minIndexList);

        for (int i = 0; i < numbers.length; i++) {
            minValueStack.pop();
            logger.info("values: {}", minValueStack.data);
            logger.info("minIndexList: {}", minValueStack.minIndexList);
        }
    }

    private void push(int num) throws Exception {
        data.add(num);
        if (minIndexList.size() == 0) {
            // 初始化minIndexList
            minIndexList.add(0);
        } else {
            // 辅助栈minIndexList push最小值的索引
            int min = getMin();
            if (num < min) {
                minIndexList.add(data.size() - 1);
            }
        }
    }

    private int pop() throws Exception {
        // 栈空，抛出异常
        if (data.size() == 0) {
            throw new Exception("stack is empty");
        }
        // pop时先获取索引
        int popIndex = data.size() - 1;
        // 获取minIndexList栈顶元素，它是最小值索引
        int minIndex = minIndexList.get(minIndexList.size() - 1);
        // 如果pop出去的索引就是最小值索引，minIndexList才出栈
        if (popIndex == minIndex) {
            minIndexList.remove(minIndexList.size() - 1);
        }
        return data.remove(data.size() - 1);
    }

    private int getMin() throws Exception {
        // 栈空，抛出异常
        if (data.size() == 0) {
            throw new Exception("stack is empty");
        }
        // 获取minIndexList栈顶元素，它是最小值索引
        int minIndex = minIndexList.get(minIndexList.size() - 1);
        return data.get(minIndex);
    }
}
