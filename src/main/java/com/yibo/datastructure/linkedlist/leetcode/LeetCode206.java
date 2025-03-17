package com.yibo.datastructure.linkedlist.leetcode;

/**
 * @Author: huangyibo
 * @Date: 2024/12/1 18:10
 * @Description: Leetcode 206 反转链表
 */
public class LeetCode206 {

    /**
     * 构造一个新链表, 遍历旧链表，把旧链表插入到新链表
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode tp = null;
        ListNode cur = head;
        while (cur != null) {
            tp = new ListNode(cur.val, tp);
            cur = cur.next;
        }
        return tp;
    }

    /**
     * 构造一个新链表, 从旧链表头部移除节点，添加到新链表头部，完成后链表即是倒序的
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        List list1 = new List(head);
        List list2 = new List(null);
        while (true) {
            ListNode node = list1.removeFirst();
            if(node == null){
                break;
            }
            list2.addFirst(node);
        }
        return list2.head;
    }

    /**
     * 递归反转链表
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if(head == null || head.next == null) {
            //返回最后节点
            return head;
        }
        //递归调用
        ListNode node = reverseList3(head.next);
        // 把当前节点前面的节点赋值到当前节点之后
        head.next.next = head;
        head.next = null;
        return node;
    }

    /**
     * 链表反转
     * n1
     * o1
     * 1 -> 2 -> 3 -> 4 -> 5 -> null
     *
     * n1
     *           o1
     * 3 -> 2 -> 1 -> 4 -> 5 -> null
     *
     * n1
     *                     o1
     * 5 -> 4 -> 3 -> 2 -> 1 -> null
     * @param head
     * @return
     */
    public ListNode reverseList4(ListNode head) {
        //空链表或链表只有一个节点直接返回
        if(head == null || head.next == null) {
            return head;
        }
        //旧的链表头部
        ListNode old1 = head;
        //旧的链表头部的下一个节点
        ListNode old2 = head.next;
        //新的链表头部
        ListNode new1 = head;
        while (old2 != null) {
            old1.next = old2.next;
            old2.next = new1;
            new1 = old2;
            old2 = old1.next;
        }
        return new1;
    }

    /**
     * 两个链表，不断的从旧链表的头部往新链表的头部搬移节点
     * @param head
     * @return
     */
    public ListNode reverseList5(ListNode head) {
        //空链表或链表只有一个节点直接返回
        if(head == null || head.next == null) {
            return head;
        }
        ListNode new1  = null;
        while (head != null){
            ListNode old = head.next;
            head.next = new1;
            new1 = head;
            head = old;
        }
        return new1;
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode listNode = new LeetCode206().reverseList5(o1);
        System.out.println(listNode);
    }
}
