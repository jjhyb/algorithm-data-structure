package com.yibo.datastructure.blockingqueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: huangyibo
 * @Date: 2025/8/10 16:10
 * @Description:
 */

@SuppressWarnings("all")
public class ArrayBlocking2Queue<E> implements BlockingQueue<E> {

    private final E[] array;
    private int head;
    private int tail;
    private AtomicInteger size = new AtomicInteger();

    public ArrayBlocking2Queue(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    private ReentrantLock headLock = new ReentrantLock();
    private Condition headWaits = headLock.newCondition();
    private ReentrantLock tailLock = new ReentrantLock();
    private Condition tailWaits = tailLock.newCondition();



    public Boolean isEmpty(){
        return size.get() == 0;
    }

    public Boolean isFull(){
        return size.get() == array.length;
    }

    @Override
    public void offer(E e) throws InterruptedException {
        int c = -1;
        tailLock.lockInterruptibly();
        try{
            //队列满, 则等待
            while (isFull()){
                tailWaits.await();
            }
            //队列不满, 则入队
            array[tail] = e;
            if(++tail == array.length){
                tail = 0;
            }
            size.getAndIncrement();
        } finally {
            tailLock.unlock();
        }
        //队列非空，唤醒等待出队
        if(c == 0){
            headLock.lockInterruptibly();
            try {
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
        }
    }

    @Override
    public Boolean offer(E e, long timeout) throws InterruptedException {
        int c = -1;
        tailLock.lockInterruptibly();
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
            c = size.getAndIncrement();
        } finally {
            tailLock.unlock();
        }
        //队列非空，唤醒等待出队
        if(c == 0){
            headLock.lock();
            try {
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public E poll() throws InterruptedException {
        E e = null;
        int c = -1;
        headLock.lockInterruptibly();
        try {
            //队列为空, 则等待
            while (isEmpty()){
                headWaits.await();
            }
            //队列非空, 则出队
            e = array[head];
            array[head] = null;
            if(++head == array.length){
                head = 0;
            }
            c = size.getAndDecrement();
        } finally {
            headLock.unlock();
        }
        //队列不满, 唤醒入队
        if(c == array.length){
            tailLock.lock();
            try {
                tailWaits.signal();
            } finally {
                tailLock.unlock();
            }
        }
        return e;
    }
}
