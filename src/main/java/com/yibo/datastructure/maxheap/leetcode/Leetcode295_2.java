package com.yibo.datastructure.maxheap.leetcode;

import java.util.PriorityQueue;

/**
 * @Author: huangyibo
 * @Date: 2025/8/19 23:42
 * @Description: 数据流的中位数 采用java.util.PriorityQueue实现
 */
public class Leetcode295_2 {

    /**
     *  为了保证两边数据量的平衡
     *      * 两边个数一样时, 左边个数加一
     *      * 两边个数不一样时, 右边个数加一
     *
     *  但是随便一个数能直接加入吗？
     *      * 左边个数加一时, 把新元素加载右边, 弹出右边最小的加在左边
     *      * 右边个数加一时, 把新元素加在左边, 弹出左边最小的加在右边
     * @param num
     */
    public void addNum(int num){
        if(left.size() == right.size()){
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    /**
     * 两边数据一致, 左右各取堆顶元素求平均
     * 左边多一个, 取左边堆顶元素
     * @return
     */
    public double findMedian(){
        if(left.size() == right.size()){
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }

    //大顶堆
    private PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

    //小顶堆
    private PriorityQueue<Integer> right = new PriorityQueue<>();

}
