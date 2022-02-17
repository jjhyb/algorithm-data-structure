package com.yibo.datastructure.binarysearchtree;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author: huangyibo
 * @Date: 2022/2/9 22:48
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        test1();

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!bst.isEmpty()){
            arrayList.add(bst.removeMin());
        }
        for (int i = 1; i < arrayList.size(); i++) {
            if(arrayList.get(i - 1) > arrayList.get(i)){
                throw new RuntimeException("Error");
            }
        }
        System.out.println("removeMin test completed.");
    }

    private static void test1() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] nums = {5, 3, 6, 8 ,4 ,2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrder();
        System.out.println("==================");
        bst.preOrderNR();
        System.out.println("==================");
        bst.inOrder();
        System.out.println("==================");
        bst.postOrder();
        System.out.println("==================");
        bst.levelOrder();
        System.out.println("==================");
        bst.inOrder();
        System.out.println("==================");
        bst.remove(5);
        bst.inOrder();
        System.out.println("==================");
        System.out.println(bst);
    }
}
