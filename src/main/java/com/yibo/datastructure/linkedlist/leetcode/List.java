package com.yibo.datastructure.linkedlist.leetcode;

/**
 * @Author: huangyibo
 * @Date: 2024/12/1 18:25
 * @Description:
 */
public class List {

    ListNode head;

    public List(ListNode head){
        this.head = head;
    }

    public void addFirst(ListNode node) {
        node.next = head;
        head = node;
    }

    public ListNode removeFirst(){
        ListNode first = head;
        if(head != null){
            head = head.next;
        }
        return first;
    }
}
