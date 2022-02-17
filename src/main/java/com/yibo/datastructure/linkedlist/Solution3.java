package com.yibo.datastructure.linkedlist;

/**
 * @Author: huangyibo
 * @Date: 2022/1/15 17:03
 * @Description: 递归版本
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 */
public class Solution3 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 递归简化版，递归有一个问题，比较耗费内存
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        head.next =  removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * 递归版本
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode result =  removeElements(head.next, val);
        if(head.val == val){
            return result;
        }else {
            head.next = result;
            return head;
        }
    }
}
