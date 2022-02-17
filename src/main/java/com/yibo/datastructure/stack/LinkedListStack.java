package com.yibo.datastructure.stack;

import com.yibo.datastructure.linkedlist.LinkedList;

/**
 * @Author: huangyibo
 * @Date: 2022/1/15 1:00
 * @Description:
 */
public class LinkedListStack<E> implements Stack<E> {

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

    public LinkedListStack(){
        dummyHead = new Node<>(null);
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(E e) {
        Node<E> node = new Node<>(e);
        node.next = dummyHead.next;
        dummyHead.next = node;
        size++;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot pop from an empty stack.");
        }
        Node<E> prev = dummyHead;
        Node<E> retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size -- ;
        return retNode.e;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot pop from an empty stack.");
        }
        return dummyHead.next.e;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: top ");
        Node<E> cur = dummyHead.next;
        while (cur != null){
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
