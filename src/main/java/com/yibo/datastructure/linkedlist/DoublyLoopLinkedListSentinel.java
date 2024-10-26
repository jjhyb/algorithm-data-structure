package com.yibo.datastructure.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @Author: huangyibo
 * @Date: 2024/10/26 23:04
 * @Description: 双向环形链表——带哨兵节点
 */
public class DoublyLoopLinkedListSentinel<E> implements Iterable<E> {

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> temp = sentinel.next;
            @Override
            public boolean hasNext() {
                return temp != sentinel;
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

    private Node<E> sentinel;

    private int size;

    public DoublyLoopLinkedListSentinel() {
        sentinel = new Node<>(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next=  sentinel;
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
        Node<E> cur = sentinel;
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
        Node<E> prev = sentinel;
        Node<E> next = sentinel.next;
        Node<E> added = new Node<>(e, prev, next);
        prev.next = added;
        next.prev = added;
        size++;
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
        Node<E> removed = sentinel.next;
        if(removed == sentinel){
            throw new IllegalArgumentException("removeFirst failed. DoublyLoopLinkedList is empty");
        }
        Node<E> prev = sentinel;
        Node<E> next = removed.next;
        prev.next = next;
        next.prev = prev;
        removed.prev = removed.next = null;
        size++;
        return removed.e;
    }

    /**
     * 向连表尾部添加节点
     * @param e
     */
    public void addLast(E e){
        Node<E> next = sentinel;
        Node<E> prev = sentinel.prev;
        Node<E> added = new Node<>(e, prev, next);
        prev.next = added;
        next.prev = added;
        size++;
    }

    /**
     * 删除链表的尾节点
     * @return
     */
    public E removeLast(){
        Node<E> removed = sentinel.prev;
        if(removed == sentinel) {
            throw new IllegalArgumentException("removeLast failed. DoublyLinkedList is empty.");
        }
        Node<E> next = sentinel;
        Node<E> prev = removed.prev;
        prev.next = next;
        next.prev = prev;
        size--;
        return removed.e;
    }

    public E removeValue(E e){
        Node<E> node = findNode(e);
        if(node == null) {
            return null;
        }
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = node.next = null;
        size --;
        return node.e;
    }

    /**
     * 根据节点值查找节点
     * @param e
     * @return
     */
    private Node<E> findNode(E e) {
        Node<E> cur = sentinel.next;
        while (cur != sentinel) {
            if(e.equals(cur.e)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 遍历 while循环方式
     * @param consumer 要执行的操作
     */
    public void loop1(Consumer<E> consumer){
        Node<E> temp = sentinel.next;
        while (temp != sentinel) {
            consumer.accept(temp.e);
            temp = temp.next;
        }
    }

    /**
     * 遍历 for循环方式
     * @param consumer 要执行的操作
     */
    public void loop2(Consumer<E> consumer){
        for(Node<E> temp = sentinel.next; temp != sentinel; temp = temp.next) {
            consumer.accept(temp.e);
        }
    }

}
