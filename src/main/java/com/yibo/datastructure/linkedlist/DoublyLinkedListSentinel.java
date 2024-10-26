package com.yibo.datastructure.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @Author: huangyibo
 * @Date: 2024/10/26 23:04
 * @Description: 双向链表——带哨兵节点
 */
public class DoublyLinkedListSentinel<E> implements Iterable<E> {

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> temp = head.next;
            @Override
            public boolean hasNext() {
                return temp != tail;
            }

            @Override
            public E next() {
                E element = temp.e;
                temp = temp.next;
                return element;
            }
        };
    }

    private static class Node<E>{
        public E e;

        public Node<E> prev;

        public Node<E> next;

        public Node(E e, Node<E> prev, Node<E> next){
            this.e = e;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node<E> head;

    private Node<E> tail;

    private int size;

    public DoublyLinkedListSentinel() {
        head = new Node<>(null,null,null);
        tail = new Node<>(null,null,null);
        head.next = tail;
        tail.prev = head;
    }

    public E get(int index) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        return findNode(index).e;
    }

    /**
     * 根据索引位置查找节点
     * @param index
     * @return
     */
    private Node<E> findNode(int index) {
        Node<E> cur = head;
        for (int i = -1; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 在链表的index(0-based)位置添加新的元素e
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node<E> prev = findNode(index - 1);
        Node<E> next = prev.next;
        Node<E> cur = new Node<>(e, prev, next);
        prev.next = cur;
        next.prev = cur;
        size ++;
    }

    /**
     * 向连表头添加元素
     * @param e
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 删除指定索引位置的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node<E> prev = findNode(index - 1);
        Node<E> retNode = prev.next;
        Node<E> next = retNode.next;
        prev.next = next;
        next.prev = prev;
        retNode.prev = retNode.next = null;
        size --;
        return retNode.e;
    }

    /**
     * 删除链表头节点
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 向连表尾部添加节点
     * @param e
     */
    public void addLast(E e){
        Node<E> prev = tail.prev;
        Node<E> cur = new Node<>(e, prev, tail);
        prev.next = cur;
        tail.prev = cur;
        size++;
    }

    /**
     * 删除链表的尾节点
     * @return
     */
    public E removeLast(){
        if(size <= 0) {
            throw new IllegalArgumentException("removeLast failed. DoublyLinkedList is empty.");
        }
        Node<E> removed = tail.prev;
        Node<E> prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
        removed.prev = removed.next = null;
        size--;
        return removed.e;
    }

    /**
     * 遍历 while循环方式
     * @param consumer 要执行的操作
     */
    public void loop1(Consumer<E> consumer){
        Node<E> temp = head.next;
        while (temp != tail) {
            consumer.accept(temp.e);
            temp = temp.next;
        }
    }

    /**
     * 遍历 for循环方式
     * @param consumer 要执行的操作
     */
    public void loop2(Consumer<E> consumer){
        for(Node<E> temp = head.next; temp != tail; temp = temp.next) {
            consumer.accept(temp.e);
        }
    }

}
