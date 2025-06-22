package com.yibo.datastructure.stack;

import com.yibo.datastructure.queue.ArrayQueue2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @Author: huangyibo
 * @Date: 2025/4/23 0:47
 * @Description:
 */
public class LinkedListStack1Test {

    @DisplayName("向栈顶压入元素")
    @Test
    public void pushTest(){
        LinkedListStack1<Integer> stack = new LinkedListStack1<>(6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.forEach(System.out::println);
    }

    @DisplayName("向栈顶压入元素")
    @Test
    public void popTest(){
        LinkedListStack1<Integer> stack = new LinkedListStack1<>(6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.forEach(System.out::println);
    }
}
