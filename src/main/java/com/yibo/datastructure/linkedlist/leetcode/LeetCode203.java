package com.yibo.datastructure.linkedlist.leetcode;

/**
 * @Author: huangyibo
 * @Date: 2024/12/2 23:27
 * @Description: 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class LeetCode203 {

    /**
     * 删除链表中所有满足 Node.val == val 的节点
     * @param head  链表头结点
     * @param val   删除的值
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = s.next;
        while (p2 != null) {
            if(p2.val == val) {
                p1.next = p2.next;
                p2.next = null;
                p2 = p1.next;
            } else {
                p1 = p2;
                p2 = p2.next;
            }
        }
        return s.next;
    }

    /**
     * 删除链表中所有满足 Node.val == val 的节点
     * @param head  链表头结点
     * @param val   删除的值
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        if(head.val == val) {
            return removeElements2(head.next, val);
        } else {
            head.next = removeElements2(head.next, val);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 6, 3, 6);
//        ListNode head = ListNode.of(7, 7, 7, 7);
        System.out.println(head);
        System.out.println(new LeetCode203().removeElements2(head, 6));
    }
}
