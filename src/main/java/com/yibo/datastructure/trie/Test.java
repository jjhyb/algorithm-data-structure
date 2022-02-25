package com.yibo.datastructure.trie;

/**
 * @Author: huangyibo
 * @Date: 2022/2/25 23:34
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("hello");
        trie.add("word");
        trie.add("lucy");
        trie.add("huang");
        trie.add("trie");
        trie.add("triel");

        System.out.println(trie.getSize());
        System.out.println(trie.contains("triel"));

        trie.delete("trie");
        System.out.println(trie.getSize());
        System.out.println(trie.contains("trie"));
        System.out.println(trie.contains("triel"));

    }
}
