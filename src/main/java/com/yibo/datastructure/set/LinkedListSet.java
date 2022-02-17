package com.yibo.datastructure.set;


/**
 * @Author: huangyibo
 * @Date: 2022/2/13 22:38
 * @Description: 基于链表LinkedList实现的集合
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> linkedList;

    private LinkedListSet(){
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if(linkedList.contains(e)){
            return;
        }
        linkedList.addFirst(e);
    }

    @Override
    public void remove(E e) {
        linkedList.delete(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
