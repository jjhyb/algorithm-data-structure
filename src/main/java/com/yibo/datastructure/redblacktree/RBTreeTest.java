package com.yibo.datastructure.redblacktree;

/**
 * @Author: huangyibo
 * @Date: 2022/3/5 17:27
 * @Description:
 */
public class RBTreeTest {

    public static void main(String[] args) {

        //红黑树构建与插入
        RBTree<Integer, String> bt = new RBTree<>();
        bt.put(0, "0");
        bt.put(1, "1");
        bt.put(2, "2");
        bt.put(3, "3");
        bt.put(4, "4");
        bt.put(5, "5");
        bt.put(6, "6");
        bt.put(7, "7");
        bt.put(8, "8");
        bt.put(9, "9");
        bt.put(10, "10");

        System.out.println(bt.getSize());
        System.out.println(bt.remove(2));
        System.out.println(bt.remove(7));
        System.out.println(bt.remove(8));
        System.out.println(bt.remove(9));
        System.out.println(bt.getSize());

        System.out.println("初始化后的大小：" + bt.getSize());

        System.out.println("初始化后的最小值：" + bt.get(bt.minimum()) +
                "  初始化后的最大值："  + bt.get(bt.maximum()));

        //删除测试
        //bt.delete(7);
        System.out.println("删除后的大小：" + bt.getSize() + "  " + bt.get(7));
        System.out.print("删除后的最小值与最大值：");
        System.out.println(bt.get(bt.minimum()) + "  "  + bt.get(bt.maximum()));

        //红黑树的深度
        System.out.println("红黑树的深度：" + bt.maxDepth());

        //遍历
        System.out.print("层次遍历：");
        bt.layerErgodic();

        System.out.println();
        System.out.print("前序遍历：");
        bt.preOrder();

        System.out.println();
        System.out.print("后序遍历：");
        bt.postOrder();

        System.out.println();
        System.out.print("中序遍历：");
        bt.inOrder();
    }
}
