package com.yibo.datastructure.stack;

/**
 * @Author: huangyibo
 * @Date: 2021/12/26 18:37
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        stack.push(100);
        stack.push(101);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }

    private static void testArrayStack(){
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        stack.push(100);
        stack.push(101);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
