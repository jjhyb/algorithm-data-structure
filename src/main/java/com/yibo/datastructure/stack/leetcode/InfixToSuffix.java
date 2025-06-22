package com.yibo.datastructure.stack.leetcode;

import java.util.LinkedList;

/**
 * @Author: huangyibo
 * @Date: 2025/5/11 18:05
 * @Description: 中缀表达式转后缀表达式
 */
public class InfixToSuffix {

    /**
     * 1、遇到非运算符 直接拼串
     * 2、遇到 + - * /
     *  a、它的运算优先级比栈顶运算符高，入栈
     *  b、否则，栈里运算符 >= 它，则先出栈，它在入栈
     * 3、遍历完成，栈里剩余运算符一次出栈
     * 4、带()
     *  a、左括号直接入栈，左括号优先级设置为0
     *  b、右括号，就把栈里到左括号为止的所有运算符出栈
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(infixToSuffix("a+b"));
        System.out.println(infixToSuffix("a+b-c"));
        System.out.println(infixToSuffix("a+b*c"));
        System.out.println(infixToSuffix("a*b-c"));
        System.out.println(infixToSuffix("(a+b)*c"));
        System.out.println(infixToSuffix("(a+b*c-d)*e"));
        System.out.println(infixToSuffix("a*(b+c)"));
    }

    public static String infixToSuffix(String exp) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if('*' == ch || '/' == ch || '+' == ch || '-' == ch){
                if(stack.isEmpty()){
                    stack.push(ch);
                } else {
                    if(priority(ch) > priority(stack.peek())){
                        sb.append(ch);
                    } else {
                        while (!stack.isEmpty() && priority(stack.peek()) >= priority(ch)){
                            sb.append(stack.pop());
                        }
                        stack.push(ch);
                    }
                }
            } else if ('(' == ch){
                stack.push(ch);
            } else if (')' == ch){
                while (!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                sb.append(ch);
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private static int priority(char c) {
        if('*' == c || '/' == c){
            return 2;
        }
        if('+' == c || '-' == c){
            return 1;
        }
        if('(' == c){
            return 0;
        }
        throw new IllegalArgumentException("不合法的运算符");
    }
}
