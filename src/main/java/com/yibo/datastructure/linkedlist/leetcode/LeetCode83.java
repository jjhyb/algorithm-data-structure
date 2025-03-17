package com.yibo.datastructure.linkedlist.leetcode;

/**
 * @Author: huangyibo
 * @Date: 2024/12/3 23:26
 * @Description: 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class LeetCode83 {

    /**
     * 定义双指针，通过循环的方式进行删除
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = p1.next;
        while (p2 != null) {
            if(p1.val == p2.val) {
                p1.next = p2.next;
                p2.next = null;
                p2 = p1.next;
            } else {
                p1 = p2;
                p2 = p1.next;
            }
        }
        return head;
    }

    /**
     * 递归的方式
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        if(head.val == head.next.val) {
            return deleteDuplicates2(head.next);
        } else {
            head.next = deleteDuplicates2(head.next);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1,1, 2, 3, 3, 5,5);
//        ListNode head = ListNode.of(7, 7, 7, 7);
        System.out.println(head);
        System.out.println(new LeetCode83().deleteDuplicates2(head));
    }
}
