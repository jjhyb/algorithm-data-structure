package com.yibo.datastructure.linkedlist;

/**
 * @Author: huangyibo
 * @Date: 2022/1/15 17:03
 * @Description: 非递归版本
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class Solution4 {

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
        //定义前置节点
        ListNode prev = null;
        //定义当前节点
        ListNode cur = head;
        while(cur != null){
            //当前节点的下一节点
            ListNode next = cur.next;
            //当前节点指向前置节点
            cur.next = prev;
            //当前节点赋值为前置节点
            prev = cur;
            //下一节点赋值为当前节点
            cur = next;
        }
        //返回反转后的链表
        return prev;
    }


}
