package com.yibo.datastructure.linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @Author: huangyibo
 * @Date: 2024/10/26 16:24
 * @Description:
 */

public class DoublyLoopLinkedListSentinelTest {

    @DisplayName("链表头部添加元素, while循环遍历元素")
    @Test
    public void loop1Test(){
        DoublyLoopLinkedListSentinel<Integer> list = new DoublyLoopLinkedListSentinel<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.loop1(System.out::println);
    }

    @DisplayName("链表头部添加元素, for循环遍历元素")
    @Test
    public void loop2Test(){
        DoublyLoopLinkedListSentinel<Integer> list = new DoublyLoopLinkedListSentinel<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.loop2(System.out::println);
    }

    @DisplayName("链表头部添加元素, forEach循环遍历元素")
    @Test
    public void forEachTest(){
        DoublyLoopLinkedListSentinel<Integer> list = new DoublyLoopLinkedListSentinel<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.forEach(System.out::println);
    }

    @DisplayName("尾部添加元素")
    @Test
    public void addLastTest(){
        DoublyLoopLinkedListSentinel<Integer> list = new DoublyLoopLinkedListSentinel<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.forEach(System.out::println);
    }

    @DisplayName("获取指定索引元素")
    @Test
    public void getTest(){
        DoublyLoopLinkedListSentinel<Integer> list = new DoublyLoopLinkedListSentinel<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list.get(2));
    }

    @DisplayName("添加节点")
    @Test
    public void addTest(){
        DoublyLoopLinkedListSentinel<Integer> list = new DoublyLoopLinkedListSentinel<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.add(2, 5);
        list.forEach(System.out::println);
    }

    @DisplayName("删除首节点")
    @Test
    public void removeFirstTest(){
        DoublyLoopLinkedListSentinel<Integer> list = new DoublyLoopLinkedListSentinel<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println(list.removeFirst());
        System.out.println("------------");
        list.forEach(System.out::println);
    }

    @DisplayName("删除指定索引元素")
    @Test
    public void removeTest(){
        DoublyLoopLinkedListSentinel<Integer> list = new DoublyLoopLinkedListSentinel<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list.remove(2));
        System.out.println("------------");
        list.forEach(System.out::println);
    }

    @DisplayName("删除指定索引元素")
    @Test
    public void removeLastTest(){
        DoublyLoopLinkedListSentinel<Integer> list = new DoublyLoopLinkedListSentinel<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list.removeLast());
        System.out.println("------------");
        list.forEach(System.out::println);
    }

    @DisplayName("删除指定索引元素")
    @Test
    public void removeValueTest(){
        DoublyLoopLinkedListSentinel<Integer> list = new DoublyLoopLinkedListSentinel<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list.removeValue(3));
        System.out.println("------------");
        list.forEach(System.out::println);
    }
}
