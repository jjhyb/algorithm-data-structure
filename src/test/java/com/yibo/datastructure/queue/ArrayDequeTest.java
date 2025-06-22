package com.yibo.datastructure.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @Author: huangyibo
 * @Date: 2025/6/22 20:54
 * @Description:
 */
public class ArrayDequeTest {

    @DisplayName("向队列插入元素")
    @org.junit.jupiter.api.Test
    public void offerTest(){
        ArrayDeque<Integer> deque = new ArrayDeque<>(5);
        deque.offerFirst(0);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerLast(3);
        deque.offerLast(4);
        deque.forEach(System.out::println);
    }

    @DisplayName("向队列插入元素")
    @Test
    public void pollTest(){
        ArrayDeque<Integer> deque = new ArrayDeque<>(5);
        deque.offerFirst(0);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerLast(3);
        deque.offerLast(4);
        System.out.println(deque.isFull());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
        System.out.println(deque.isEmpty());
    }

    @DisplayName("向队列插入元素")
    @Test
    public void peekTest(){
        ArrayDeque<Integer> deque = new ArrayDeque<>(5);
        deque.offerFirst(0);
        deque.offerLast(1);
        deque.offerFirst(2);
        deque.offerLast(3);
        System.out.println(deque.isFull());
        System.out.println(deque.peekLast());
        System.out.println(deque.peekFirst());
        System.out.println(deque.isEmpty());
    }
}
