package com.yibo.datastructure.linkedlist.leetcode;

/**
 * @Author: huangyibo
 * @Date: 2024/12/3 0:03
 * @Description: 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class LeetCode19 {

    /**
     * 递归删除
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);
        recursion(s, n);
        return s.next;
    }

    public int recursion(ListNode head, int n) {
        if(head == null) {
            return 0;
        }
        int nth = recursion(head.next, n);
        if(nth == n) {
            head.next = head.next.next;
        }
        return nth + 1;
    }

    /**
     * 循环遍历，快慢指针
     * p1 p2起始节点位置相同
     * p2先向后移动 n + 1个位置
     * 然后p1和p2同时向后移动位置
     * p2移动到null节点的时候停止，p1正好指向待删除节点的上一个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = s;
        for (int i = 0; i < n+1; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return s.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
//        ListNode head = ListNode.of(7, 7, 7, 7);
        System.out.println(head);
        System.out.println(new LeetCode19().removeNthFromEnd1(head, 1));
    }
}
