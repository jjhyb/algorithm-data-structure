package com.yibo.datastructure.linkedlist;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @Author: huangyibo
 * @Date: 2022/1/15 22:29
 * @Description:双向链表
 */
public class DoubleLinkedList<E> {

    private class Node<E>{
        public E e;

        public Node<E> next;

        public Node<E> prev;

        Node(Node<E> prev, E e, Node<E> next) {
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

    private Integer size;

    public DoubleLinkedList(){
        size = 0;
    }

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
     * 在链表头添加新元素
     * @param e
     */
    public void addFirst(E e){
        Node<E> node = head;
        Node<E> newNode = new Node<>(null, e, node);
        head = newNode;
        if(node == null){
            tail = newNode;
        }else{
            node.prev = newNode;
        }
        size++;
    }

    /**
     * 在链表尾部添加新元素
     * @param e
     */
    public void addLast(E e){
        Node<E> node = tail;
        Node<E> newNode = new Node<>(node, e, null);
        tail = newNode;
        if (node == null)
            head = newNode;
        else
            node.next = newNode;
        size++;
    }

    public void add(Integer index, E e){
        if(index < 0 || index > size - 1){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        if(index == 0){
            addFirst(e);
            return;
        }
        if(index == size - 1){
            addLast(e);
            return;
        }
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node<E> prev = cur.prev;
        Node<E> newNode = new Node<>(prev, e, cur);
        cur.prev = newNode;
        prev.next = newNode;
        size++;
    }

    /**
     * 获取链表的第一个元素
     * @return
     */
    public E getFirst(){
        if (head == null)
            throw new NoSuchElementException();
        return head.e;
    }

    /**
     * 获取链表的最后一个元素
     * @return
     */
    public E getLast(){
        if (tail == null)
            throw new NoSuchElementException();
        return tail.e;
    }

    /**
     * 获取链表的index(0-based)位置的元素e
     * 在链表中不是一个常规操作，仅仅作为练习
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index > size - 1){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 修改链表的index(0-based)位置的元素
     * 在链表中不是一个常规操作，仅仅作为练习
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index < 0 || index > size - 1){
            throw new IllegalArgumentException("Update failed. Illegal index.");
        }
        if(index == 0){
            head.e = e;
            return;
        }
        if(index == size - 1){
            tail.e = e;
            return;
        }
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node<E> cur = head;
        while (cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除第一个元素，返回删除的元素
     * @return
     */
    public E removeFirst(){
        if (head == null)
            throw new NoSuchElementException();
        Node<E> delNode = head;
        if(delNode.next == null){
            head = tail = null;
        }else {
            head = delNode.next;
            head.prev = null;
            delNode.next = null;
        }
        size--;
        return delNode.e;
    }

    /**
     * 删除链表最后一个元素，返回删除的元素
     * @return
     */
    public E removeLast(){
        if (tail == null)
            throw new NoSuchElementException();
        Node<E> delNode = tail;
        if(delNode.prev == null){
            head = tail = null;
        }else {
            tail = delNode.prev;
            tail.next = null;
            delNode.prev = null;
        }
        size--;
        return delNode.e;
    }

    /**
     * 删除链表元素
     * @param e
     * @return
     */
    public boolean delete(E e) {
        if (head == null)
            throw new NoSuchElementException();

        Node<E> cur = head;
        while (cur != null) {
            if(cur.e.equals(e)){
                Node<E> prev = cur.prev;
                Node<E> next = cur.next;

                //当前节点为头结点
                if (prev == null) {
                    head = next;
                } else {
                    prev.next = next;
                    cur.prev = null;
                }
                //当前节点为尾节点
                if (next == null) {
                    tail = prev;
                } else {
                    next.prev = prev;
                    cur.next = null;
                }
                size--;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除index(0-based)位置的元素，返回删除的元素
     * 在链表中不是一个常规操作，仅仅作为练习
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index > size - 1){
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        if(index == 0){
            return removeFirst();
        }
        if(index == size - 1){
            return removeLast();
        }
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        cur.next = null;
        cur.prev = null;
        size -- ;
        return cur.e;
    }

    /**
     * 反转链表
     * @return
     */
    public void reverseList() {
        //定义前置节点
        Node<E> prev = null;
        //定义当前节点
        Node<E> cur = head;
        while(cur != null){
            //当前节点的下一节点
            Node<E> next = cur.next;
            //当前节点next指向前置节点
            cur.next = prev;
            //当前节点prev指向next节点
            cur.prev = next;
            //当前节点赋值为前置节点
            prev = cur;
            //下一节点赋值为当前节点
            cur = next;
        }
        //设置反转后的链表
        head = prev;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList: head ");
        Node<E> cur = head;
        while (cur != null){
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("NULL tail");
        return sb.toString();
    }
}
