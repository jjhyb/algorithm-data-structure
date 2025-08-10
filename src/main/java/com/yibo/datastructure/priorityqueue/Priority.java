package com.yibo.datastructure.priorityqueue;

/**
 * @Author: huangyibo
 * @Date: 2025/7/6 18:50
 * @Description:
 */
public interface Priority {

    /**
     * 返回对象的优先级, 约定数字越大, 优先级越高
     * @return 优先级
     */
    int priority();
}
