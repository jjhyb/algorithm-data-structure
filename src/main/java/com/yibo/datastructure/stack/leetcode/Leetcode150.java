package com.yibo.datastructure.stack.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: huangyibo
 * @Date: 2025/5/11 17:20
 * @Description: 逆波兰表达式求值
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 *
 * 请你计算该表达式。返回一个表示表达式值的整数。
 *
 * 注意：
 *      有效的算符为 '+'、'-'、'*' 和 '/' 。
 *      每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 *      两个整数之间的除法总是 向零截断 。
 *      表达式中不含除零运算。
 *      输入是一个根据逆波兰表示法表示的算术表达式。
 *      答案及所有中间计算结果可以用 32 位 整数表示。
 *
 * 逆波兰表达式，也称为后缀表达式，即运算符写在后面
 * 示例 1：
 *
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 */

public class Leetcode150 {

    /**
     * 解题思路：
     *  从左向右遍历，
     *  遇到数字放入栈，
     *  遇到运算符，从栈中取两个数字进行运算，运算后的结果，在压入栈
     *  遍历结束，栈中剩余的元素就是返回的结果
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if ("+".equals(token)){
                Integer val2 = stack.pop();
                Integer val1 = stack.pop();
                stack.push(val1 + val2);
            } else if("-".equals(token)){
                Integer val2 = stack.pop();
                Integer val1 = stack.pop();
                stack.push(val1 - val2);
            } else if("*".equals(token)){
                Integer val2 = stack.pop();
                Integer val1 = stack.pop();
                stack.push(val1 * val2);
            } else if("/".equals(token)){
                Integer val2 = stack.pop();
                Integer val1 = stack.pop();
                stack.push(val1 / val2);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
