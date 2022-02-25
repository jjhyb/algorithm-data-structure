package com.yibo.datastructure.trie;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: huangyibo
 * @Date: 2022/2/26 1:04
 * @Description: leetcode 677. 键值映射
 *
 * 设计一个 map ，满足以下几点:
 *  字符串表示键，整数表示值
 *  返回具有前缀等于给定字符串的键的值的总和
 *
 * 实现一个 MapSum 类：
 *  MapSum() 初始化 MapSum 对象
 *  void insert(String key, int val) 插入 key-val 键值对，
 *      字符串表示键 key ，整数表示值 val 。
 *      如果键 key 已经存在，那么原来的键值对 key-value 将被替代成新的键值对。
 *  int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *  
 */

public class MapSum {

    private class Node{

        public int value;

        public Map<Character,Node> next;

        public Node(){
            this(0);
        }

        public Node(int value){
            this.value = value;
            next = new TreeMap<>();
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if(cur.next.get(ch) == null){
                cur.next.put(ch,new Node());
            }
            cur = cur.next.get(ch);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(cur.next.get(ch) == null){
                return 0;
            }
            cur = cur.next.get(ch);
        }
        return sum(cur);
    }

    private int sum(Node node){
        int res = node.value;
        for (Character ch : node.next.keySet()) {
            res += sum(node.next.get(ch));
        }
        return res;
    }
}
