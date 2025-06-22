package com.yibo.datastructure.stack.leetcode;

import java.util.Stack;

/**
 * @Author: huangyibo
 * @Date: 2025/4/26 23:58
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class Leetcode20 {


    /**
     * 解题思路
     * (        [       {
     * 底       栈       顶
     * )        ]       }
     * 遇到左括号, 要把配对的右括号放入栈顶
     * 遇到右括号, 把他与栈顶元素对比
     *      若相等, 栈顶元素弹出,继续对比后面一组
     *      若不等, 无效括号, 返回false
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(')');
            } else if(ch == '['){
                stack.push(']');
            } else if(ch == '{'){
                stack.push('}');
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                Character temp = stack.pop();
                if(ch != temp){
                    return false;
                }
            }
        }
        //如果栈里面还有字符的话，那么也不行，因为意味着还有字符没办法匹配
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Leetcode20 s = new Leetcode20();
        System.out.println(s.isValid("([{}])"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("()"));
        System.out.println("----------------");
        System.out.println(s.isValid("[)"));
        System.out.println(s.isValid("([)]"));
        System.out.println(s.isValid("([]"));
// )
        System.out.println(s.isValid("("));
        System.out.println("----------------");
        System.out.println(s.isValid(")("));
        System.out.println(s.isValid("]["));
    }
}
