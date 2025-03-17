package com.yibo.datastructure.linkedlist.leetcode;

/**
 * @Author: huangyibo
 * @Date: 2024/12/6 23:58
 * @Description: 链表的中间结点
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class LeetCode876 {

    /**
     *定义两个指针，一个指针一次走一步，另一个指针一次走两步，
     * 直到快指针为空或者快指针的下一个节点为空，那么慢指针就是中间节点
     *           p1
     *                     p2
     * 1 -> 2 -> 3 -> 4 -> 5 -> null
     *
     *                p1
     *                               p2
     * 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.of(1, 3, 8, 9);
        ListNode list2 = ListNode.of(1, 2, 3, 4, 5);
        ListNode list3 = ListNode.of( 4, 5, 10, 11, 13, 16);
        System.out.println(new LeetCode876().middleNode(list1));
        System.out.println(new LeetCode876().middleNode(list2));
        System.out.println(new LeetCode876().middleNode(list3));
    }
}
