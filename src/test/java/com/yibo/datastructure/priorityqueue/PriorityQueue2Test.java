package com.yibo.datastructure.priorityqueue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: huangyibo
 * @Date: 2025/7/6 19:14
 * @Description:
 */
public class PriorityQueue2Test {

    @DisplayName("向队列插入元素")
    @Test
    public void poll() {
        PriorityQueue2<Entry> queue = new PriorityQueue2<>(5);
        queue.offer(new Entry("task1", 4));
        queue.offer(new Entry("task2", 3));
        queue.offer(new Entry("task3", 2));
        queue.offer(new Entry("task4", 5));
        queue.offer(new Entry("task5", 1));
        boolean task6 = queue.offer(new Entry("task6", 6));
        System.out.println(task6);

        System.out.println(Arrays.toString(queue.array));
        System.out.println(queue.poll().priority());

        System.out.println(Arrays.toString(queue.array));
        System.out.println(queue.poll().priority());
        System.out.println(queue.poll().priority());
        System.out.println(queue.poll().priority());
        System.out.println(queue.poll().priority());
    }
}
