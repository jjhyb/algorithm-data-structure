package com.yibo.datastructure.linkedlist.leetcode;

/**
 * @Author: huangyibo
 * @Date: 2024/12/3 23:40
 * @Description: 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class LeetCode82 {

    /**
     * 定义三指针，通过循环的方式进行删除
     * p1   p2   p3
     * s -> 1 -> 1 -> 1 -> 2 -> 3 -> null
     *
     * p1   p2        p3
     * s -> 1 -> 1 -> 1 -> 2 -> 3 -> null
     *
     * p1   p2             p3
     * s -> 1 -> 1 -> 1 -> 2 -> 3 -> null
     *
     * p1   p3
     * s -> 2 -> 3 -> null
     *
     * p1   p2   p3
     * s -> 2 -> 3 -> null
     *
     *      p1   p2   p3
     * s -> 2 -> 3 -> null
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2;
        ListNode p3;
        while ((p2 = p1.next) != null && (p3 = p2.next) != null) {
            if(p2.val == p3.val) {
                p3 = p3.next;
                while (p3 != null && p2.val == p3.val){
                    p3 = p3.next;
                }
                p1.next = p3;
            } else {
                p1 = p2;
            }
        }
        return s.next;
    }

    /**
     * 递归的方式删除重复的元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        if(head.val == head.next.val) {
            ListNode node = head.next.next;
            while (node != null && node.val == head.val) {
                node = node.next;
            }
            return deleteDuplicates2(node);
        } else {
            head.next = deleteDuplicates2(head.next);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 1, 2, 3, 3, 5, 5);
//        ListNode head = ListNode.of(7, 7, 7, 7);
        System.out.println(head);
        System.out.println(new LeetCode82().deleteDuplicates(head));
    }
}
