package com.yibo.datastructure.redblacktree;

/**
 * @Author: huangyibo
 * @Date: 2022/3/1 22:05
 * @Description: 红黑树
 */

public class RBTree1<K extends Comparable<K>, V> {

    private RBNode<K, V> root;    // 根结点

    private static final boolean RED   = false;
    private static final boolean BLACK = true;

    //节点类型
    static class RBNode<K extends Comparable<K>, V> {

        private RBNode<K, V> parent;  // 父结点

        private RBNode<K, V> left;    // 左孩子

        private RBNode<K, V> right;   // 右孩子
        
        private boolean color;      // 颜色

        private K key;

        private V value;

        public RBNode(RBNode<K, V> parent, RBNode<K, V> left, RBNode<K, V> right, boolean color, K key, V value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public String toString() {
            return ""+key+(this.color==RED?"(R)":"B");
        }
    }

    public RBTree1() {
        root=null;
    }

    private RBNode<K, V> parentOf(RBNode<K, V> RBNode) {
        return RBNode!=null ? RBNode.parent : null;
    }

    private boolean colorOf(RBNode<K, V> RBNode) {
        return RBNode!=null ? RBNode.color : BLACK;
    }

    private boolean isRed(RBNode<K, V> RBNode) {
        return (RBNode != null) && (RBNode.color == RED);
    }

    private boolean isBlack(RBNode<K, V> RBNode) {
        return !isRed(RBNode);
    }

    private void setBlack(RBNode<K, V> RBNode) {
        if (RBNode!=null){
            RBNode.color = BLACK;
        }
    }

    private void setRed(RBNode<K, V> RBNode) {
        if (RBNode!=null){
            RBNode.color = RED;
        }
    }

    private void setParent(RBNode<K, V> RBNode, RBNode<K, V> parent) {
        if (RBNode!=null){
            RBNode.parent = parent;
        }
    }

    private void setColor(RBNode<K, V> RBNode, boolean color) {
        if (RBNode!=null){
            RBNode.color = color;
        }
    }

    /*
     * 前序遍历"红黑树"
     */
    private void preOrder(RBNode<K, V> tree) {
        if(tree != null) {
            System.out.print(tree.key+":"+tree.value+" ,");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    /*
     * 中序遍历"红黑树"
     */
    private void inOrder(RBNode<K, V> tree) {
        if(tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key+":"+tree.value+" ,");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }


    /*
     * 后序遍历"红黑树"
     */
    private void postOrder(RBNode<K, V> tree) {
        if(tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key+":"+tree.value+" ,");
        }
    }

    public void postOrder() {
        postOrder(root);
    }


    /*
     * (递归实现)查找"红黑树x"中键值为key的节点
     */
    private RBNode<K, V> search(RBNode<K, V> x, K key) {
        if (x == null) {
            return x;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    public RBNode<K, V> search(K key) {
        return search(root, key);
    }

    /*
     * (非递归实现)查找"红黑树x"中键值为key的节点
     */
    private RBNode<K, V> iterativeSearch(RBNode<K, V> x, K key) {
        while (x!=null) {
            int cmp = key.compareTo(x.key);

            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x;
        }

        return x;
    }

    public RBNode<K, V> iterativeSearch(K key) {
        return iterativeSearch(root, key);
    }

    /*
     * 查找最小结点：返回tree为根结点的红黑树的最小结点。
     */
    private RBNode<K, V> minimum(RBNode<K, V> tree) {
        if (tree == null) {
            return null;
        }

        while(tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    public K minimum() {
        RBNode<K, V> p = minimum(root);
        if (p != null){
            return p.key;
        }

        return null;
    }

    /*
     * 查找最大结点：返回tree为根结点的红黑树的最大结点。
     */
    private RBNode<K, V> maximum(RBNode<K, V> tree) {
        if (tree == null) {
            return null;
        }

        while(tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    public K maximum() {
        RBNode<K, V> p = maximum(root);
        if (p != null) {
            return p.key;
        }

        return null;
    }

    /*
     * 找结点(x)的后继结点。即，查找"红黑树中数据值大于该结点"的"最小结点"。
     */
    public RBNode<K, V> successor(RBNode<K, V> x) {
        // 如果x存在右孩子，则"x的后继结点"为 "以其右孩子为根的子树的最小结点"。
        if (x.right != null)
            return minimum(x.right);

        // 如果x没有右孩子。则x有以下两种可能：
        // (01) x是"一个左孩子"，则"x的后继结点"为 "它的父结点"。
        // (02) x是"一个右孩子"，则查找"x的最低的父结点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"x的后继结点"。
        RBNode<K, V> y = x.parent;
        while ((y != null) && (x == y.right)) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    /*
     * 找结点(x)的前驱结点。即，查找"红黑树中数据值小于该结点"的"最大结点"。
     */
    public RBNode<K, V> predecessor(RBNode<K, V> x) {
        // 如果x存在左孩子，则"x的前驱结点"为 "以其左孩子为根的子树的最大结点"。
        if (x.left != null) {
            return maximum(x.left);
        }

        // 如果x没有左孩子。则x有以下两种可能：
        // (01) x是"一个右孩子"，则"x的前驱结点"为 "它的父结点"。
        // (01) x是"一个左孩子"，则查找"x的最低的父结点，并且该父结点要具有右孩子"，找到的这个"最低的父结点"就是"x的前驱结点"。
        RBNode<K, V> y = x.parent;
        while ((y != null) && (x == y.left)) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    /*
     * 对红黑树的节点(x)进行左旋转
     *
     * 左旋示意图(对节点x进行左旋)：
     *      px                              px
     *     /                               /
     *    x                               y
     *   /  \      --(左旋)-.           / \                #
     *  lx   y                          x  ry
     *     /   \                       /  \
     *    ly   ry                     lx  ly
     *
     *
     */
    private void leftRotate(RBNode<K, V> x) {
        // 设置x的右孩子为y
        RBNode<K, V> y = x.right;

        // 将 “y的左孩子” 设为 “x的右孩子”；
        // 如果y的左孩子非空，将 “x” 设为 “y的左孩子的父亲”
        x.right = y.left;
        if (y.left != null)
            y.left.parent = x;

        // 将 “x的父亲” 设为 “y的父亲”
        y.parent = x.parent;

        if (x.parent == null) {
            this.root = y;            // 如果 “x的父亲” 是空节点，则将y设为根节点
        } else {
            if (x.parent.left == x)
                x.parent.left = y;    // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
            else
                x.parent.right = y;    // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
        }

        // 将 “x” 设为 “y的左孩子”
        y.left = x;
        // 将 “x的父节点” 设为 “y”
        x.parent = y;
    }

    /*
     * 对红黑树的节点(y)进行右旋转
     *
     * 右旋示意图(对节点y进行左旋)：
     *            py                               py
     *           /                                /
     *          y                                x
     *         /  \      --(右旋)-.            /  \                     #
     *        x   ry                           lx   y
     *       / \                                   / \                   #
     *      lx  rx                                rx  ry
     *
     */
    private void rightRotate(RBNode<K, V> y) {
        // 设置x是当前节点的左孩子。
        RBNode<K, V> x = y.left;

        // 将 “x的右孩子” 设为 “y的左孩子”；
        // 如果"x的右孩子"不为空的话，将 “y” 设为 “x的右孩子的父亲”
        y.left = x.right;
        if (x.right != null){
            x.right.parent = y;
        }

        // 将 “y的父亲” 设为 “x的父亲”
        x.parent = y.parent;

        if (y.parent == null) {
            this.root = x;            // 如果 “y的父亲” 是空节点，则将x设为根节点
        } else {
            if (y == y.parent.right)
                y.parent.right = x;    // 如果 y是它父节点的右孩子，则将x设为“y的父节点的右孩子”
            else
                y.parent.left = x;    // (y是它父节点的左孩子) 将x设为“x的父节点的左孩子”
        }

        // 将 “y” 设为 “x的右孩子”
        x.right = y;

        // 将 “y的父节点” 设为 “x”
        y.parent = x;
    }

    /*
     * 红黑树插入修正函数
     *
     * 在向红黑树中插入节点之后(失去平衡)，再调用该函数；
     * 目的是将它重新塑造成一颗红黑树。
     *
     * 参数说明：
     *     RBNode 插入的结点        // 对应《算法导论》中的z
     */
    private void insertFixUp(RBNode<K, V> RBNode) {
        RBNode<K, V> parent, gparent;

        // 若“父节点存在，并且父节点的颜色是红色”
        while (((parent = parentOf(RBNode))!=null) && isRed(parent)) {
            gparent = parentOf(parent);

            //若“父节点”是“祖父节点的左孩子”
            if (parent == gparent.left) {
                // Case 1条件：叔叔节点是红色
                RBNode<K, V> uncle = gparent.right;
                if (isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    RBNode = gparent;
                    continue;
                }

                // Case 2条件：叔叔是黑色，且当前节点是右孩子
                if (parent.right == RBNode) {
                    RBNode<K, V> tmp;
                    leftRotate(parent);
                    tmp = parent;
                    parent = RBNode;
                    RBNode = tmp;
                }

                // Case 3条件：叔叔是黑色，且当前节点是左孩子。
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            } else {    //若“z的父节点”是“z的祖父节点的右孩子”
                // Case 1条件：叔叔节点是红色
                RBNode<K, V> uncle = gparent.left;
                if (isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    RBNode = gparent;
                    continue;
                }

                // Case 2条件：叔叔是黑色，且当前节点是左孩子
                if (parent.left == RBNode) {
                    RBNode<K, V> tmp;
                    rightRotate(parent);
                    tmp = parent;
                    parent = RBNode;
                    RBNode = tmp;
                }

                // Case 3条件：叔叔是黑色，且当前节点是右孩子。
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }

        // 将根节点设为黑色
        setBlack(this.root);
    }

    /*
     * 将结点插入到红黑树中
     *
     * 参数说明：
     *     RBNode 插入的结点        // 对应《算法导论》中的RBNode
     */
    private void insert(RBNode<K, V> RBNode) {
        int cmp;
        RBNode<K, V> y = null;
        RBNode<K, V> x = this.root;

        // 1. 将红黑树当作一颗二叉查找树，将节点添加到二叉查找树中。
        while (x != null) {
            y = x;
            cmp = RBNode.key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else
                x = x.right;
        }

        RBNode.parent = y;
        if (y != null) {
            cmp = RBNode.key.compareTo(y.key);
            if (cmp < 0)
                y.left = RBNode;
            else
                y.right = RBNode;
        } else {
            this.root = RBNode;
        }

        // 2. 设置节点的颜色为红色
        RBNode.color = RED;

        // 3. 将它重新修正为一颗二叉查找树
        insertFixUp(RBNode);
    }

    /*
     * 新建结点(key)，并将其插入到红黑树中
     *
     * 参数说明：
     *     key 插入结点的键值
     */
    public void insert(K key, V value) {
        RBNode<K, V> RBNode = new RBNode<>(null,null,null, BLACK, key, value);

        insert(RBNode);
    }

    /**
     * 红黑树删除修正函数
     * 在从红黑树中删除插入节点之后(红黑树失去平衡)，再调用该函数；
     * 目的是将它重新塑造成一颗红黑树。
     * @param RBNode 待修正的节点
     * @param parent 待修正的节点的父节点
     */
    private void removeFixUp(RBNode<K, V> RBNode, RBNode<K, V> parent) {
        RBNode<K, V> other;

        while ((RBNode == null || isBlack(RBNode)) && (RBNode != this.root)) {
            if (parent.left == RBNode) {
                other = parent.right;
                if (isRed(other)) {
                    // Case 1: x的兄弟w是红色的
                    setBlack(other);
                    setRed(parent);
                    leftRotate(parent);
                    other = parent.right;
                }

                if ((other.left==null || isBlack(other.left)) &&
                        (other.right==null || isBlack(other.right))) {
                    // Case 2: x的兄弟w是黑色，且w的俩个孩子也都是黑色的
                    setRed(other);
                    RBNode = parent;
                    parent = parentOf(RBNode);
                } else {
                    if (other.right==null || isBlack(other.right)) {
                        // Case 3: x的兄弟w是黑色的，并且w的左孩子是红色，右孩子为黑色。
                        setBlack(other.left);
                        setRed(other);
                        rightRotate(other);
                        other = parent.right;
                    }
                    // Case 4: x的兄弟w是黑色的；并且w的右孩子是红色的，左孩子任意颜色。
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.right);
                    leftRotate(parent);
                    RBNode = this.root;
                    break;
                }
            } else {

                other = parent.left;
                if (isRed(other)) {
                    // Case 1: x的兄弟w是红色的
                    setBlack(other);
                    setRed(parent);
                    rightRotate(parent);
                    other = parent.left;
                }

                if ((other.left==null || isBlack(other.left)) &&
                        (other.right==null || isBlack(other.right))) {
                    // Case 2: x的兄弟w是黑色，且w的俩个孩子也都是黑色的
                    setRed(other);
                    RBNode = parent;
                    parent = parentOf(RBNode);
                } else {

                    if (other.left==null || isBlack(other.left)) {
                        // Case 3: x的兄弟w是黑色的，并且w的左孩子是红色，右孩子为黑色。
                        setBlack(other.right);
                        setRed(other);
                        leftRotate(other);
                        other = parent.left;
                    }

                    // Case 4: x的兄弟w是黑色的；并且w的右孩子是红色的，左孩子任意颜色。
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.left);
                    rightRotate(parent);
                    RBNode = this.root;
                    break;
                }
            }
        }

        if (RBNode != null){
            setBlack(RBNode);
        }
    }

    /**
     * 删除结点(RBNode)，并返回被删除的结点
     * @param RBNode 删除的结点
     */
    private void remove(RBNode<K, V> RBNode) {
        RBNode<K, V> child, parent;
        boolean color;

        // 被删除节点的"左右孩子都不为空"的情况。
        if ( (RBNode.left!=null) && (RBNode.right!=null) ) {
            // 被删节点的后继节点。(称为"取代节点")
            // 用它来取代"被删节点"的位置，然后再将"被删节点"去掉。
            RBNode<K, V> replace = RBNode;

            // 获取后继节点
            replace = replace.right;
            while (replace.left != null)
                replace = replace.left;

            // "RBNode节点"不是根节点(只有根节点不存在父节点)
            if (parentOf(RBNode)!=null) {
                if (parentOf(RBNode).left == RBNode)
                    parentOf(RBNode).left = replace;
                else
                    parentOf(RBNode).right = replace;
            } else {
                // "RBNode节点"是根节点，更新根节点。
                this.root = replace;
            }

            // child是"取代节点"的右孩子，也是需要"调整的节点"。
            // "取代节点"肯定不存在左孩子！因为它是一个后继节点。
            child = replace.right;
            parent = parentOf(replace);
            // 保存"取代节点"的颜色
            color = colorOf(replace);

            // "被删除节点"是"它的后继节点的父节点"
            if (parent == RBNode) {
                parent = replace;
            } else {
                // child不为空
                if (child!=null)
                    setParent(child, parent);
                parent.left = child;

                replace.right = RBNode.right;
                setParent(RBNode.right, replace);
            }

            replace.parent = RBNode.parent;
            replace.color = RBNode.color;
            replace.left = RBNode.left;
            RBNode.left.parent = replace;

            if (color == BLACK)
                removeFixUp(child, parent);

            RBNode = null;
            return ;
        }

        if (RBNode.left !=null) {
            child = RBNode.left;
        } else {
            child = RBNode.right;
        }

        parent = RBNode.parent;
        // 保存"取代节点"的颜色
        color = RBNode.color;

        if (child!=null)
            child.parent = parent;

        // "RBNode节点"不是根节点
        if (parent!=null) {
            if (parent.left == RBNode)
                parent.left = child;
            else
                parent.right = child;
        } else {
            this.root = child;
        }

        if (color == BLACK)
            removeFixUp(child, parent);

        RBNode = null;
    }

    /**
     * 删除结点键为key的节点，并返回被删除的结点的值
     * @param key
     * @return
     */
    public V remove(K key) {
        if(key == null){
            throw new NullPointerException("key is null.");
        }

        RBNode<K, V> RBNode = search(root, key);
        if(RBNode == null){
            return null;
        }

        remove(RBNode);

        return RBNode.value;
    }

    /**
     * 销毁红黑树, 递归调用销毁红黑树的节点
     * @param RBNode
     */
    private void destroy(RBNode<K, V> RBNode) {
        //递归结束条件
        if (RBNode == null){
            return ;
        }

        //递归调用，销毁当前节点的左子树
        if (RBNode.left != null){
            destroy(RBNode.left);
        }

        //递归调用，销毁当前节点的右子树
        if (RBNode.right != null){
            destroy(RBNode.right);
        }

        RBNode = null;
    }

    /**
     * 销毁红黑树
     */
    public void clear() {
        destroy(root);
        root = null;
    }
}
