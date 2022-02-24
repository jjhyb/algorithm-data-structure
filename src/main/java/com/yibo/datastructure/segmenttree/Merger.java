package com.yibo.datastructure.segmenttree;

/**
 * @Author: huangyibo
 * @Date: 2022/2/24 22:08
 * @Description: 对元素的融合操作
 * 用于将两个元素融合成一个元素, 配合线段树的合并操作使用
 * @FunctionalInterface这个注解是jdk8中函数式接口声明, 加不加不影响
 */

@FunctionalInterface
public interface Merger<E> {

    E merger(E a, E b);
}
