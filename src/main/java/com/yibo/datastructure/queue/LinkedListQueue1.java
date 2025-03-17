package com.yibo.datastructure.queue;

import java.util.Iterator;

/**
 * @Author: huangyibo
 * @Date: 2025/1/7 23:33
 * @Description: 带哨兵节点的循环链表队列
 */
public class LinkedListQueue1<E> implements Queue1<E>, Iterable<E> {

    private static class Node<E>{
        public E e;

        public Node<E> next;

        public Node(E e, Node<E> next){
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node<E> head, tail;

    private int size;

    private int capacity = Integer.MAX_VALUE;

    public LinkedListQueue1(){
        //初始化哨兵节点，既是头结点，又是尾节点
        tail = head = new Node<>(null,null);
        tail.next = head;
        size = 0;
    }

    public LinkedListQueue1(Integer capacity){
        this();
        this.capacity = capacity;
    }



    @Override
    public boolean offer(E e) {
        if(size >= capacity){
            return false;
        }
        Node<E> added = new Node<>(e, head);
        tail.next = added;
        tail = added;
        size ++;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        Node<E> cur = head.next;
        head.next = cur.next;
        if(cur == tail) {
            tail = head;
        }
        cur.next = null;
        size --;
        return cur.e;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return head.next.e;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != head;
            }

            @Override
            public E next() {
                E e = p.e;
                p = p.next;
                return e;
            }
        };
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public int getSize() {
        return size;
    }
}
