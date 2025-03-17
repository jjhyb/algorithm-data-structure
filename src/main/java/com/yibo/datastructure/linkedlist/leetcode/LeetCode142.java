package com.yibo.datastructure.linkedlist.leetcode;

/**
 * @Author: huangyibo
 * @Date: 2024/12/10 22:10
 * @Description: 环形链表 II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class LeetCode142 {

    /**
     * 第一阶段，判断链表是否有环
     *  定义两个指针，一个快指针一次走两步，一个慢指针一次走一步
     *  如果快指针能追上慢指针，说明链表有环
     *  如果快指针走到了链表尾部等于null，说明链表没有环
     *
     *  第二阶段，如果链表有环，沿用第一阶段的指针
     *  快指针从链表头部，一次向后移动一个节点
     *  慢指针从链表的环处每次向后移动一个节点
     *  当两个指针再次相等，说明这个节点是链表开始入环的第一个节点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode h = head;
        ListNode t = head;
        while (h != null && h.next != null) {
            t = t.next;
            h = h.next.next;
            if(h == t){
                h = head;
                while (true){
                    if(h == t){
                        return h;
                    }
                    h = h.next;
                    t = t.next;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode n12 = new ListNode(12, null);
        ListNode n11 = new ListNode(11, n12);
        ListNode n10 = new ListNode(10, n11);
        ListNode n9 = new ListNode(9, n10);
        ListNode n8 = new ListNode(8, n9);
        ListNode n7 = new ListNode(7, n8);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        n12.next = n1;

        ListNode node = new LeetCode142().detectCycle(n1);
        System.out.println(node.val);
    }
}
