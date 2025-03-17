package com.yibo.datastructure.queue;

import com.yibo.datastructure.linkedlist.SinglyLinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @Author: huangyibo
 * @Date: 2025/1/7 23:48
 * @Description:
 */
public class LinkedListQueue1Test {

    @DisplayName("向队列尾部插入元素")
    @Test
    public void offerTest(){
        LinkedListQueue1<Integer> queue = new LinkedListQueue1<>(3);
        queue.offer(0);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.forEach(System.out::println);
    }

    @DisplayName("从队列头获取值，不移除元素")
    @Test
    public void peekTest(){
        LinkedListQueue1<Integer> queue = new LinkedListQueue1<>();
        queue.offer(0);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        Integer e = queue.peek();
        System.out.println(e);
        queue.forEach(System.out::println);
    }

    @DisplayName("从队列头获取值，并移除")
    @Test
    public void pollTest(){
        LinkedListQueue1<Integer> queue = new LinkedListQueue1<>();
        queue.offer(0);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        Integer e = queue.poll();
        System.out.println(e);
        System.out.println("--------------------------------");
        queue.forEach(System.out::println);
    }
}
