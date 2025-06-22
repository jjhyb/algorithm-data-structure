package com.yibo.datastructure.queue;

import java.util.Iterator;

/**
 * @Author: huangyibo
 * @Date: 2025/5/12 0:05
 * @Description: 基于双向链表实现
 */
public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {

    static class Node<E>{
        Node<E> prev;
        E e;
        Node<E> next;

        public Node(Node<E> prev, E e, Node<E> next) {
            this.prev = prev;
            this.e = e;
            this.next = next;
        }
    }

    int capacity;
    int size;

    Node<E> sentinel = new Node<>(null, null, null);

    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    @Override
    public boolean offerFirst(E e) {
        if(isFull()) {
            return false;
        }
        Node<E> next = sentinel.next;
        Node<E> added = new Node<>(sentinel, e, next);
        sentinel.next = added;
        next.prev = added;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if(isFull()) {
            return false;
        }
        Node<E> prev = sentinel.prev;
        Node<E> added = new Node<>(prev, e, sentinel);
        prev.next = added;
        sentinel.prev = added;
        size++;
        return false;
    }

    @Override
    public E pollFirst() {
        if(isEmpty()){
            return null;
        }
        Node<E> removed = sentinel.next;
        Node<E> next = removed.next;
        sentinel.next = next;
        next.prev = sentinel;
        size--;
        return removed.e;
    }

    @Override
    public E pollLast() {
        if(isEmpty()){
            return null;
        }
        Node<E> removed = sentinel.prev;
        Node<E> prev = removed.prev;
        sentinel.prev = prev;
        prev.next = sentinel;
        size--;
        return removed.e;
    }

    @Override
    public E peekFirst() {
        if(isEmpty()){
            return null;
        }
        return sentinel.next.e;
    }

    @Override
    public E peekLast() {
        if(isEmpty()){
            return null;
        }
        return sentinel.prev.e;
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
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public E next() {
                E e = p.e;
                p = p.next;
                return e;
            }
        };
    }
}
