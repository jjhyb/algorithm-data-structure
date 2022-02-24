package com.yibo.datastructure.segmenttree;

/**
 * @Author: huangyibo
 * @Date: 2022/2/24 21:33
 * @Description: 线段树
 */

public class SegmentTree<E> {

    //线段树，底层数组实现
    private E[] tree;

    //原数组副本
    private E[] data;

    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger){
        this.merger = merger;
        this.data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        // 对于有n个元素的区间, 使用数组实现线段树的话, 需要4n的空间来存储
        this.tree = (E[])new Object[arr.length * 4];
        //构建线段树
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在treeIndex的位置创建表示区间[left, right]的线段树
     * @param treeIndex 根节点所在的索引
     * @param left      treeIndex对应的左端点
     * @param right     treeIndex对应的右端点
     */
    private void buildSegmentTree(int treeIndex, int left, int right){
        // 递归到底的情况
        if (left == right){
            //区间长度为1, 只有一个元素的时候
            //此时节点存储的信息就是该节点本身
            tree[treeIndex] = data[left];
            return;
        }

        //treeIndex为根节点的左孩子节点索引
        int leftTreeIndex = leftChild(treeIndex);
        //treeIndex为根节点的右孩子点索引
        int rightTreeIndex = rightChild(treeIndex);

        int mid = (left + right) >>> 1;

        //以leftTreeIndex为根节点，创建表示区间[left, mid]的线段树
        buildSegmentTree(leftTreeIndex, left, mid);

        //以rightTreeIndex为根节点，创建表示区间[mid + 1, right]的线段树
        buildSegmentTree(rightTreeIndex, mid + 1, right);

        //具体的业务相关数据，综合左、右两个线段数据，得到其根节点的信息
        //可以是、最大值、最小值、和、乘积等等
        tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length){
            throw new IllegalArgumentException("index is illegal.");
        }
        return data[index];
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index){
        return 2 * index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index){
        return 2 * index + 2;
    }

    /**
     * 返回区间[queryL, queryR]的值
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int queryL, int queryR){
        if(queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR){
            throw new IllegalArgumentException("index is illegal.");
        }

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 在以treeIndex为根的线段树中[left, right]的范围里，搜索区间[queryL, queryR]的值
     * @param treeIndex
     * @param left
     * @param right
     * @param queryL
     * @param queryR
     * @return
     */
    private E query(int treeIndex, int left, int right, int queryL, int queryR){
        //如果查询区间值和treeIndex的左右区间值重合，直接返回
        if(left == queryL && right == queryR){
            return tree[treeIndex];
        }

        int mid = (left + right) >>> 1;

        //treeIndex为根节点的左孩子节点索引
        int leftTreeIndex = leftChild(treeIndex);
        //treeIndex为根节点的右孩子点索引
        int rightTreeIndex = rightChild(treeIndex);

        // 要查找的区间左边界大于mid时, 说明只需要到右子树进行查找即可
        if(queryL >= mid + 1){
            return query(rightTreeIndex, mid + 1, right, queryL, queryR);
        }else if(queryR <= mid){
            // 要查找的区间右边界小于等于mid时, 说明只需要到左子树进行查找即可
            return query(leftTreeIndex, left, mid, queryL, queryR);
        }
        //queryL < mid < queryR 的情况, 需要对左右子树分别进行查找
        E leftResult = query(leftTreeIndex, left, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, right, mid + 1, queryR);
        //进行融合操作
        return merger.merger(leftResult, rightResult);
    }

    /**
     * 将index索引的值, 更新为e
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index < 0 || index >= data.length){
            throw new IllegalArgumentException("index is illegal.");
        }
        data[index] = e;
        //在以treeIndex为根的线段树中[left, right]的范围里，更新index的值
        set(0, 0, data.length - 1, index, e);
    }

    /**
     * 在以treeIndex为根的线段树中[left, right]的范围里，更新index的值
     * @param treeIndex
     * @param left
     * @param right
     * @param index
     * @param e
     */
    private void set(int treeIndex, int left, int right, int index, E e){
        // 递归终止条件
        //如果查询区间值和treeIndex的左右区间值重合，直接更新元素e
        if (left == right) {
            tree[treeIndex] = e;
            return;
        }

        int mid = (left + right) >>> 1;
        //treeIndex为根节点的左孩子节点索引
        int leftTreeIndex = leftChild(treeIndex);
        //treeIndex为根节点的右孩子点索引
        int rightTreeIndex = rightChild(treeIndex);

        // 要查找的index大于mid时, 说明只需要到右子树进行查找即可
        if(index >= mid + 1){
            set(rightTreeIndex, mid + 1, right, index, e);
        }else { //index <= mid
            // 要查找的index小于等于mid时, 说明只需要到左子树进行查找即可
            set(leftTreeIndex, left, mid, index, e);
        }

        //更新完值之后，对更新相关的每一层的根节点重新进行融合操作
        tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length; i++) {
            if(tree[i] != null){
                res.append(tree[i]);
            }else {
                res.append("null");
            }
            if(i != tree.length - 1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
