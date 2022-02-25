package com.yibo.datastructure.trie;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: huangyibo
 * @Date: 2022/2/26 0:51
 * @Description: leetcode 211. 添加与搜索单词 - 数据结构设计
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 */

public class WordDictionary {

    private class Node{
        public boolean isword;

        public Map<Character,Node> next;

        public Node(){
            this(false);
        }

        public Node(boolean isword){
            this.isword = isword;
            next = new TreeMap<>();
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(cur.next.get(ch) == null){
                cur.next.put(ch,new Node());
            }
            cur = cur.next.get(ch);
        }
        if(!cur.isword){
            cur.isword = true;
        }
    }

    /**
     * Returns if the word is in the data structure.
     * A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(root,word,0);
    }

    private boolean match(Node node,String word,int index){
        if(index == word.length()){
            return node.isword;
        }
        char ch = word.charAt(index);
        if(ch != '.'){
            if(node.next.get(ch) == null){
                return false;
            }
            return match(node.next.get(ch),word,index + 1);
        }else {
            for (Character nextChar : node.next.keySet()) {
                if(match(node.next.get(nextChar),word,index + 1)){
                    return true;
                }
            }
            return false;
        }
    }
}
