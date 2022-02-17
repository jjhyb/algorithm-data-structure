package com.yibo.datastructure.queue;

import com.yibo.datastructure.linkedlist.LinkedList;

/**
 * @Author: huangyibo
 * @Date: 2022/1/15 1:21
 * @Description:
 */
public class LinkedListQueue<E> implements Queue<E> {

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

    private Node<E> head, tail;

    private Integer size;

    public LinkedListQueue(){
        head = null;
        tail = null;
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
    public void enqueue(E e) {
        if(tail == null){
            head = tail = new Node<>(e);
        }else {
            tail = tail.next = new Node<>(e);
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node<E> retNode = head;
        head = head.next;
        retNode.next = null;
        if(head == null){
            tail = null;
        }
        size --;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: front ");
        Node<E> cur = head;
        while (cur != null){
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("NULL tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);

            if(i % 3 == 0){
                linkedListQueue.dequeue();
                System.out.println(linkedListQueue);
            }
        }
    }
}
