package com.yibo.algorithm.stringmatch;

/**
 * @Author: huangyibo
 * @Date: 2022/3/26 15:26
 * @Description:
 */
public class StringMatch {

    public String longestPrefix(String s) {
        int j = 0;
        String result = "";
        for (int i = 1; i < s.length(); i++) {
            String preStr = s.substring(j, i);
            String postStr = s.substring(s.length() - i);
            if(preStr.equals(postStr)){
                result = preStr;
            }
        }
        return result;
    }
}
