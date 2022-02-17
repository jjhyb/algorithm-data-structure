package com.yibo.datastructure.linkedlist;

/**
 * @Author: huangyibo
 * @Date: 2022/1/15 17:03
 * @Description: 递归版本
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class Solution5 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode reverse = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        //返回反转后的链表
        return reverse;
    }
}
