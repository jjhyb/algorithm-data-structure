package com.yibo.datastructure.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @Author: huangyibo
 * @Date: 2025/5/12 0:26
 * @Description:
 */
public class LinkedListDequeTest {

    @DisplayName("向队列插入元素")
    @Test
    public void offerTest(){
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(5);
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
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(5);
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
}
