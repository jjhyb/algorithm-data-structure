package com.yibo.datastructure.stack;

import java.util.Iterator;

/**
 * @Author: huangyibo
 * @Date: 2025/4/23 0:33
 * @Description:
 */
public class LinkedListStack1<E>  implements Stack1<E>, Iterable<E>{

    private int capacity;
    private int size;

    private Node<E> head = new Node<>(null, null);

    public LinkedListStack1(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    @Override
    public boolean push(E e) {
        if(isFull()){
            return false;
        }
        head.next = new Node<>(e, head.next);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        size--;
        return first.e;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return head.next.e;
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

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> cur = head.next;
            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public E next() {
                E e = cur.e;
                cur = cur.next;
                return e;
            }
        };
    }

    static class Node<E> {
        E e;
        Node<E> next;

        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }
    }
}
