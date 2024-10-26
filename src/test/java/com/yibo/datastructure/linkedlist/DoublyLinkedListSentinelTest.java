package com.yibo.datastructure.linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @Author: huangyibo
 * @Date: 2024/10/26 16:24
 * @Description:
 */

public class DoublyLinkedListSentinelTest {

    @DisplayName("链表头部添加元素, while循环遍历元素")
    @Test
    public void loop1Test(){
        DoublyLinkedListSentinel<Integer> list = new DoublyLinkedListSentinel<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.loop1(System.out::println);
    }

    @DisplayName("链表头部添加元素, for循环遍历元素")
    @Test
    public void loop2Test(){
        DoublyLinkedListSentinel<Integer> list = new DoublyLinkedListSentinel<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.loop2(System.out::println);
    }

    @DisplayName("链表头部添加元素, forEach循环遍历元素")
    @Test
    public void forEachTest(){
        DoublyLinkedListSentinel<Integer> list = new DoublyLinkedListSentinel<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.forEach(System.out::println);
    }

    @DisplayName("尾部添加元素")
    @Test
    public void addLastTest(){
        DoublyLinkedListSentinel<Integer> list = new DoublyLinkedListSentinel<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.forEach(System.out::println);
    }

    @DisplayName("获取指定索引元素")
    @Test
    public void getTest(){
        DoublyLinkedListSentinel<Integer> list = new DoublyLinkedListSentinel<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list.get(2));
    }

    @DisplayName("添加节点")
    @Test
    public void addTest(){
        DoublyLinkedListSentinel<Integer> list = new DoublyLinkedListSentinel<>();
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
        DoublyLinkedListSentinel<Integer> list = new DoublyLinkedListSentinel<>();
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
        DoublyLinkedListSentinel<Integer> list = new DoublyLinkedListSentinel<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list.remove(3));
        System.out.println("------------");
        list.forEach(System.out::println);
    }

    @DisplayName("删除指定索引元素")
    @Test
    public void removeLastTest(){
        DoublyLinkedListSentinel<Integer> list = new DoublyLinkedListSentinel<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list.removeLast());
        System.out.println("------------");
        list.forEach(System.out::println);
    }
}
