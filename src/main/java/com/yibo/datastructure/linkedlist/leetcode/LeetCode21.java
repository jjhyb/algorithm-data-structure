package com.yibo.datastructure.linkedlist.leetcode;

/**
 * @Author: huangyibo
 * @Date: 2024/12/4 23:57
 * @Description: 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LeetCode21 {

    /**
     * 通过循环遍历两个链表，每一个链表节点直接进行比较，插入到新建的链表中
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode s = new ListNode(-1, null);
        ListNode p = s;
        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if(list1 != null) {
            p.next = list1;
        }
        if(list2 != null) {
            p.next = list2;
        }
        return s.next;
    }

    /**
     * 递归合并两个有序链表
     * 递归函数应该返回：
     *  1、更小的那个链表节点，并把他剩余节点和另外一个链表再次递归
     *  2、返回之前，更新此节点的next
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        if(list1.val <= list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.of(1, 3, 8, 9);
        ListNode list2 = ListNode.of(1, 2, 3, 4, 5);
//        ListNode head = ListNode.of(7, 7, 7, 7);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(new LeetCode21().mergeTwoLists2(list1, list2));
    }
}
