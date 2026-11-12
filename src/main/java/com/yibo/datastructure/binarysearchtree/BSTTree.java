package com.yibo.datastructure.binarysearchtree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: huangyibo
 * @Date: 2025/9/15 23:13
 * @Description: 二分搜索树
 */
@SuppressWarnings("all")
public class BSTTree<K extends Comparable<K>, V> {

    //二分搜索树节点类
    private class BSTNode<K, V>{

        public K key;
        public V value;

        public BSTNode<K, V> left;

        public BSTNode<K, V> right;

        public BSTNode(K key) {
            this.key = key;
        }

        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    // 根节点
    private BSTNode<K, V> root;

    // 树容量
    private Integer size;

    /**
     * 获取元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回二分搜索树是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 查找关键字对应的值
     * @param key
     * @return
     */
    public V get(K key){
        //循环版本
        BSTNode<K, V> node = root;
        while (node != null){
            if(key.compareTo(node.key) < 0){
                node = node.left;
            } else if (key.compareTo(node.key) > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
        //递归版本
        //return doGet(root, key);
    }

    /**
     * 递归根据key获取value
     * @param node
     * @param key
     * @return
     */
    public V doGet(BSTNode<K, V> node, K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) < 0){
            return doGet(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return doGet(node.right, key);
        } else {
            return node.value;
        }
    }

    /**
     * 查找最小关键字对应的值
     * @return
     */
    public V min(){
        //递归方式
        //return doMain(root);

        //非递归方式
        return max(root);
    }

    public V min(BSTNode<K, V> node){
        //非递归方式
        if(node == null){
            return null;
        }
        BSTNode<K, V> p = node;
        while (p.left != null){
            p = p.left;
        }
        return p.value;
    }

    /**
     * 递归方法
     * @param node
     * @return
     */
    private V doMain(BSTNode<K, V> node){
        if(node == null){
            return null;
        }
        if(node.left == null){
            return node.value;
        }
        return doMain(node.left);
    }

    /**
     * 查找最大关键字对应的值
     * @return
     */
    public V max(){
        //递归方式
        //return doMax(root);

        //非递归方式
        return max(root);
    }

    public V max(BSTNode<K, V> node){
        if(node == null){
            return null;
        }
        BSTNode<K, V> p = node;
        while (p.left != null){
            p = p.left;
        }
        return p.value;
    }

    private V doMax(BSTNode<K, V> node){
        if(node == null){
            return null;
        }
        if(node.left == null){
            return node.value;
        }
        return doMax(node.left);
    }

    /**
     * 存储关键字和对应值
     * @param key
     * @param value
     */
    public void put(K key, V value){
        BSTNode<K, V> node = root;
        BSTNode<K, V> parent = null;
        while (node != null){
            parent = node;
            if(key.compareTo(node.key) < 0){
                node = node.left;
            } else if (key.compareTo(node.key) > 0) {
                node = node.right;
            } else {
                //1.存在key 更新
                node.value = value;
                return;
            }
        }
        //2.不存在key　新增
        if(parent == null){
            root = new BSTNode<>(key, value);
            return;
        }
        if(key.compareTo(parent.key) < 0){
            parent.left = new BSTNode<>(key, value);
        } else{
            parent.right = new BSTNode<>(key, value);
        }
    }

    /**
     * 查找key的前驱值
     * @param key
     */
    public V successor(K key){
        BSTNode<K, V> p = root;
        BSTNode<K, V> leftFrom = null;
        while (p != null){
            if(key.compareTo(p.key) < 0){
                p = p.left;
            } else if(key.compareTo(p.key) > 0){
                leftFrom = p;
                p = p.right;
            } else {
                break;
            }
        }
        //没找到节点
        if(p == null){
            return null;
        }
        //找到节点, 情况1:节点有左子树,此时前驱节点就是左子树的最大值
        if(p.left != null){
            return max(p.left);
        }
        //找到节点,情况2:节点没有左子树,若离它最近的,自左而来的祖先就是前驱节点
        return leftFrom != null ? leftFrom.value : null;
    }

    /**
     * 查找key的后驱值
     * @param key
     * @return
     */
    public V predecessor(K key){
        BSTNode<K, V> p = root;
        BSTNode<K, V> rightFrom = null;
        while (p != null){
            while (p != null){
                if(key.compareTo(p.key) < 0){
                    rightFrom = p;
                    p = p.left;
                } else if(key.compareTo(p.key) > 0){
                    p = p.right;
                } else {
                    break;
                }
            }
        }
        //没找到节点
        if(p == null){
            return null;
        }
        //找到节点, 情况1:节点有右子树,此时后驱节点就是右子树的最小值
        if(p.right != null){
            return min(p.right);
        }
        //找到节点,情况2:节点没有右子树,若离它最近的,自右而来的祖先就是后驱节点
        return rightFrom != null ? rightFrom.value : null;
    }

    /**
     * 根据Key删除
     * @param key
     * @return
     */
    public V delete(K key){
        BSTNode<K, V> p = root;
        BSTNode<K, V> parent = root;
        while (p != null){
            while (p != null){
                if(key.compareTo(p.key) < 0){
                    parent = p;
                    p = p.left;
                } else if(key.compareTo(p.key) > 0){
                    parent = p;
                    p = p.right;
                } else {
                    break;
                }
            }
        }
        //待删除节点为空
        if(p == null){
            return null;
        }
        //情况3,待删除节点左右子树都为空，走情况1或情况2都可以
        if(p.left == null){
            //情况1,待删除节点左子树为空
            shift(parent, p, p.right);
        } else if (p.right == null) {
            //情况2,待删除节点右子树为空
            shift(parent, p, p.left);
        } else {
            //情况4,待删除节点左右子树都不为空
            //4.1 被删除节点找后继
            BSTNode<K, V> s = p.right;
            //被删除节点的后继节点的父节点
            BSTNode<K, V> sParent = p;
            while (s.left != null){
                sParent = s;
                s = s.left;
                //循环结束 s即为被删除节点的后继节点
            }
            //4.2 删除和后继节点不相邻
            if(sParent != p){
                //处理后继节点,上浮转移
                // 因为s即为被删除节点的后继节点(最小值),不存在s还有左子树的可能
                shift(sParent, s, s.right);
                s.right = p.right;
            }
            //4.3 后继节点取代被删除节点
            shift(parent, p, s);
            s.left = p.left;
        }
        return p.value;
    }

    /**
     * 上浮转移
     * @param parent    被删除节点的父节点
     * @param delete    被删除节点
     * @param child     被删除节点的子节点
     */
    private void shift(BSTNode<K, V> parent, BSTNode<K, V> delete, BSTNode<K, V> child){
        if(parent == null){
            root = child;
        } else if (parent.left == delete) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    /**
     * 根据Key删除 递归方式
     * @param key
     * @return
     */
    public V deleteRecursion(K key){
        ArrayList<V> result = new ArrayList<>();
        root = doDelete(root, key, result);
        return result.isEmpty() ? null : result.get(0);
    }

    public BSTNode<K, V> doDelete(BSTNode<K, V> node, K key,  ArrayList<V> result){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) < 0){
            node.left = doDelete(node.left, key, result);
            return node;
        }
        if(key.compareTo(node.key) > 0){
            node.right = doDelete(node.right, key, result);
            return node;
        }
        result.add(node.value);
        //情况1,待删除节点左子树为空
        if(node.left == null){
            return node.right;
        }
        //情况2,待删除节点右子树为空
        if(node.right == null){
            return node.left;
        }
        //情况3,待删除节点左右子树都不为空
        BSTNode<K, V> s = node.right;
        while (s.left != null){
            s = s.left;
        }
        s.right = doDelete(node.right, s.key, new ArrayList<>());
        s.left = node.left;
        return s;
    }
}
