package com.yibo.datastructure.trie;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @Author: huangyibo
 * @Date: 2022/2/25 23:03
 * @Description: Trie
 */

public class Trie {

    private class Node{

        //true表示一个单词结尾，false表示非单词结尾
        private boolean isWord;

        //k表示单词的组成字符, Node表示组成单词的剩余字符
        private Map<Character, Node> next;

        public Node(){
            this(false);
        }

        public Node(boolean isWord){
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }
    }

    //Trie数据结构的根节点
    private Node root;

    //Trie存储个多少个单词
    private int size;

    //初始化Trie, root节点不存储数据
    public Trie(){
        this.root = new Node();
        this.size = 0;
    }

    /**
     * 获得Trie中存储的单词数量
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 向Trie中添加一个新的单词word
     * @param word
     */
    public void add(String word){
        //从根节点开始添加单词
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            //提取单词中的字母
            char ch = word.charAt(i);
            //如果root.next指向的TreeMap中不包含ch
            if(cur.next.get(ch) == null){
                //直接创建一个新的节点映射
                cur.next.put(ch, new Node());
            }
            //存在ch节点，移动cur，继续查找下一字符的映射节点，重复循环
            cur = cur.next.get(ch);
        }

        //如果不存在该单词，存在的话size不能加1
        if(!cur.isWord){
            //循环完成之后，表示单词添加成功
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询单词word是否在Trie中
     * @param word
     * @return
     */
    public boolean contains(String word){
        //从根节点开始
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            //提取单词中的字母
            char ch = word.charAt(i);
            //如果root.next指向的TreeMap中不包含ch
            if(cur.next.get(ch) == null){
                //直接返回false
                return false;
            }
            //存在ch节点，移动cur，继续查找下一字符的映射节点，重复循环
            cur = cur.next.get(ch);
        }

        //直接返回cur.isWord
        // 如果不存在该单词,该值为false, 存在则返回true
        return cur.isWord;
    }

    /**
     * 查询是否在Trie中有单词以prefix为前缀
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix){
        //从根节点开始
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            //提取单词中的字母
            char ch = prefix.charAt(i);
            //如果root.next指向的TreeMap中不包含ch
            if(cur.next.get(ch) == null){
                //直接返回false
                return false;
            }
            //存在ch节点，移动cur，继续查找下一字符的映射节点，重复循环
            cur = cur.next.get(ch);
        }

        //循环走完，则表示Trie中有单词以prefix为前缀
        return true;
    }

    /**
     * 删除Trie中word单词
     * @param word
     */
    public void delete(String word){
        //删除前查找是否存在这个单词，存在才能删除
        if(!contains(word)){
            //不存在该单词，直接返回
            return;
        }

        Stack<Node> preNodes = new Stack<>();
        //存在word单词
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            //添加前驱节点
            preNodes.push(cur);
            cur = cur.next.get(ch);
        }

        //到了单词末尾，节点是叶子节点
        if(cur.next.size() == 0){
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                //获得前驱节点
                Node pre = preNodes.pop();

                //判断是否为其他单词的结尾，是则停止删除节点
                //判断待删除节点是否还有其他孩子，有则停止删除节点
                if((i != word.length() - 1 && pre.next.get(ch).isWord) || pre.next.get(ch).next.size() != 0){
                    break;
                }
                pre.next.remove(ch);//删除节点
            }
        }else {
            //不是单词末尾，节点不是叶子节点
            cur.isWord = false;
        }
        size--;
    }
}
