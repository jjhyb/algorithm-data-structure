package com.yibo.datastructure.linkedlist.leetcode;

/**
 * @Author: huangyibo
 * @Date: 2024/12/7 0:09
 * @Description: 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表
 * 如果是，返回 true ；否则，返回 false 。
 */
public class LeetCode234 {

    /**
     * 1、对原始链表找中间节点，同时对前半个链表进行反转
     * 2、反转后的链表和原链表中间靠后半段逐一 比较
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        //慢指针
        ListNode p1 = head;
        //快指针
        ListNode p2 = head;
        //新链表头
        ListNode n1 = null;
        //旧链表头
        ListNode o1 = head;
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;

            //反转链表
            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }
        if(p2 != null) {
            p1 = p1.next;
        }
        while (n1 != null) {
            if(n1.val != p1.val) {
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }

    /**
     * 1、对原始链表找中间节点
     * 2、中间节点往后的半个链表反转
     * 3、反转后的链表和原链表逐一 比较
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode middle = middleNode(head);
        ListNode newHead = reverse(middle);
        while (newHead != null) {
            if(newHead.val != head.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    /**
     * 查找中间节点
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    /**
     * 链表反转
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        ListNode n1 = null;
        while (head != null) {
            ListNode o1 = head.next;
            head.next = n1;
            n1 = head;
            head = o1;
        }
        return n1;
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.of(1, 2, 2, 1);
        ListNode list2 = ListNode.of(1, 2, 3, 2, 1);
        ListNode list3 = ListNode.of( 1, 2);
        /*System.out.println(new LeetCode234().isPalindrome(list1));
        System.out.println(new LeetCode234().isPalindrome(list2));
        System.out.println(new LeetCode234().isPalindrome(list3));*/
        System.out.println(new LeetCode234().isPalindrome2(list1));
        System.out.println(new LeetCode234().isPalindrome2(list2));
        System.out.println(new LeetCode234().isPalindrome2(list3));
    }
}
