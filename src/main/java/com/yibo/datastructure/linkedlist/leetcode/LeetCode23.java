package com.yibo.datastructure.linkedlist.leetcode;

/**
 * @Author: huangyibo
 * @Date: 2024/12/4 23:57
 * @Description: 合并 K 个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        return split(lists, 0, lists.length - 1);
    }

    /**
     * 返回合并后的链表
     * @param lists
     * @param i 数据的左边界
     * @param j 数据的右边界
     * @return
     */
    private ListNode split(ListNode[] lists, int i, int j) {
        if(i == j){
            return lists[i];
        }
        int m = (i + j) >>> 1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists, m + 1, j);
        return mergeTwoLists(left, right);
    }

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

    public static void main(String[] args) {
        ListNode list1 = ListNode.of(1, 3, 8, 9);
        ListNode list2 = ListNode.of(1, 2, 3, 4, 5);
        ListNode list3 = ListNode.of( 4, 5, 10, 11, 13);
        ListNode[] lists = {list1, list2, list3};
        System.out.println(new LeetCode23().mergeKLists(lists));
    }
}
