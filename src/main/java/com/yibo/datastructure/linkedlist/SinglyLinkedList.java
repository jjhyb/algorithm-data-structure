package com.yibo.datastructure.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @Author: huangyibo
 * @Date: 2024/10/20 18:05
 * @Description: 单向链表
 */

public class SinglyLinkedList<E> implements Iterable<E> {

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> temp = head;
            /**
             * 是否有下一个元素
             * @return
             */
            @Override
            public boolean hasNext() {
                return temp != null;
            }

            /**
             * 返回当前元素, 并指向下一个元素
             * @return
             */
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

    //头指针
    private Node<E> head;

    //元素数量
    private Integer size = 0;

    /**
     * 获取元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向连表头添加元素
     * @param e
     */
    public void addFirst(E e){
        //1.链表为空的情况
        //head = new Node<>(e,null);
        //2.链表非空
        head = new Node<>(e, head);
        size++;
    }

    /**
     * 向连表尾部添加元素
     * @param e
     */
    public void addLast(E e) {
        Node<E> node = findLast();
        if(node == null){
            addFirst(e);
            return;
        }
        node.next = new Node<>(e, null);
        size++;
    }

    /**
     * 查找连表尾部最后一个元素
     * @return
     */
    private Node<E> findLast(){
        if(head == null){
            return null;
        }
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 获取链表的index(0-based)位置的元素e
     * 在链表中不是一个常规操作，仅仅作为练习
     * @param index 索引
     * @return
     */
    public E get(int index) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        return findNode(index).e;
    }

    private Node<E> findNode(int index) {
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
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
        if(index == 0){
            addFirst(e);
            return;
        }
        //查找索引的上一个节点
        Node<E> prev = findNode(index - 1);
        prev.next = new Node<>(e, prev.next);
        size++;
    }

    /**
     * 删除链表头节点
     * @return
     */
    public E removeFirst(){
        if(head == null){
            throw new IllegalArgumentException("Remove failed. SinglyLinkedList is empty");
        }
        Node<E> retNode = head;
        head = head.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    /**
     * 从链表中删除index(0-based)位置的元素，返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        if(index == 0) {
            return removeFirst();
        }
        //查找索引的上一个节点
        Node<E> prev = findNode(index - 1);
        Node<E> retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    /**
     * 遍历 while循环方式
     * @param consumer 要执行的操作
     */
    public void loop1(Consumer<E> consumer){
        Node<E> temp = head;
        while (temp != null) {
            consumer.accept(temp.e);
            temp = temp.next;
        }
    }

    /**
     * 遍历 for循环方式
     * @param consumer 要执行的操作
     */
    public void loop2(Consumer<E> consumer){
        for(Node<E> temp = head; temp != null; temp = temp.next) {
            consumer.accept(temp.e);
        }
    }


}
