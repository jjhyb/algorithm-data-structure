package com.yibo.datastructure.blockingqueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: huangyibo
 * @Date: 2025/8/10 16:10
 * @Description:
 */

@SuppressWarnings("all")
public class ArrayBlockingQueue<E> implements BlockingQueue<E> {

    private final E[] array;
    private int head;
    private int tail;
    private int size;

    public ArrayBlockingQueue(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    private ReentrantLock lock = new ReentrantLock();
    private Condition headWaits = lock.newCondition();
    private Condition tailWaits = lock.newCondition();

    public Boolean isEmpty(){
        return size == 0;
    }

    public Boolean isFull(){
        return size == array.length;
    }

    @Override
    public void offer(E e) throws InterruptedException {
        lock.lockInterruptibly();
        try{
            while (isFull()){
                tailWaits.await();
            }
            array[tail] = e;
            if(++tail == array.length){
                tail = 0;
            }
            size++;
            headWaits.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Boolean offer(E e, long timeout) throws InterruptedException {
        lock.lockInterruptibly();
        try{
            long nanos = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isFull()){
                if(nanos <= 0){
                    return Boolean.FALSE;
                }
                nanos = tailWaits.awaitNanos(nanos);
            }
            array[tail] = e;
            if(++tail == array.length){
                tail = 0;
            }
            size++;
            headWaits.signal();
            return Boolean.TRUE;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E poll() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isEmpty()){
                headWaits.await();
            }
            E e = array[head];
            array[head] = null;
            if(++head == array.length){
                head = 0;
            }
            size--;
            tailWaits.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }
}
