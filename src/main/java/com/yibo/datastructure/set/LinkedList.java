package com.yibo.datastructure.set;

import java.util.NoSuchElementException;

/**
 * @Author: huangyibo
 * @Date: 2022/1/10 23:10
 * @Description:
 */
public class LinkedList<E> {

    private class Node<E>{
        public E e;

        public Node<E> next;

        public Node(E e){
            this.e = e;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node<E> dummyHead;

    private Integer size;

    public LinkedList(){
        dummyHead = new Node<>(null);
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
     * 在链表的index(0-based)位置添加新的元素e
     * 在链表中不是一个常规操作，仅仅作为练习
     * @param e
     */
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node<E> node = new Node<>(e);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    /**
     * 在链表头添加新元素
     * @param e
     */
    public void addFirst(E e){
        Node<E> node = new Node<>(e);
        node.next = dummyHead.next;
        dummyHead.next = node;
        size++;
    }

    /**
     * 在链表尾部添加新元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获取链表的index(0-based)位置的元素e
     * 在链表中不是一个常规操作，仅仅作为练习
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改链表的index(0-based)位置的元素
     * 在链表中不是一个常规操作，仅仅作为练习
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Update failed. Illegal index.");
        }
        Node<E> cur = dummyHead.next;
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
        Node<E> cur = dummyHead;
        while (cur != null){
            if(cur.e.equals(e)){
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
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node<E> retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size -- ;
        return retNode.e;
    }

    /**
     * 从链表中删除第一个元素，返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除链表最后一个元素，返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 删除链表元素
     * @param e
     * @return
     */
    public boolean delete(E e) {
        if (isEmpty())
            throw new NoSuchElementException();

        Node<E> cur = dummyHead;
        for (int i = 0; i < size; i++) {
            if(cur.next.e.equals(e)){
                Node<E> delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
                size -- ;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 反转链表
     * @return
     */
    public void reverseList() {
        //定义前置节点
        Node<E> prev = null;
        //定义当前节点
        Node<E> cur = dummyHead.next;
        while(cur != null){
            //当前节点的下一节点
            Node<E> next = cur.next;
            //当前节点指向前置节点
            cur.next = prev;
            //当前节点赋值为前置节点
            prev = cur;
            //下一节点赋值为当前节点
            cur = next;
        }
        //设置反转后的链表
        dummyHead.next = prev;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList: head ");
        Node<E> cur = dummyHead.next;
        while (cur != null){
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("NULL tail");
        return sb.toString();
    }
}
