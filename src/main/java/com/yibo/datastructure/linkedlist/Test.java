package com.yibo.datastructure.linkedlist;

/**
 * @Author: huangyibo
 * @Date: 2022/1/11 0:18
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        linkedList2Test();
        System.out.println("-----------------------------");
        linkedListTest();
        System.out.println("-----------------------------");
        DoubleLinkedListTest();
    }

    public static void DoubleLinkedListTest() {
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.addLast(100);
        System.out.println(linkedList);

        linkedList.add(5,666);
        System.out.println(linkedList);

        System.out.println(linkedList.delete(9));
        System.out.println(linkedList);

        System.out.println(linkedList.delete(100));
        System.out.println(linkedList);

        System.out.println(linkedList.delete(666));
        System.out.println(linkedList);

        linkedList.remove(1);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        linkedList.set(2,99);
        System.out.println(linkedList);

        System.out.println(linkedList.get(2));

        linkedList.reverseList();
        System.out.println(linkedList);
    }

    public static void linkedList2Test() {
        LinkedList2<Integer> linkedList = new LinkedList2<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.addLast(100);
        System.out.println(linkedList);

        linkedList.add(5,666);
        System.out.println(linkedList);

        System.out.println(linkedList.delete(9));
        System.out.println(linkedList);

        System.out.println(linkedList.delete(100));
        System.out.println(linkedList);

        System.out.println(linkedList.delete(666));
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.set(3,99);
        System.out.println(linkedList);

        linkedList.reverseList();
        System.out.println(linkedList);
    }


    public static void linkedListTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.addLast(100);
        System.out.println(linkedList);

        linkedList.add(5,666);
        System.out.println(linkedList);

        System.out.println(linkedList.delete(9));
        System.out.println(linkedList);

        System.out.println(linkedList.delete(100));
        System.out.println(linkedList);

        System.out.println(linkedList.delete(666));
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.reverseList();
        System.out.println(linkedList);
    }
}
