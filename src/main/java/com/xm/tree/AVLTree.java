package com.xm.tree;

public class AVLTree {
    class Node {
        int key, height;
        Node left, right;
        public Node(int key) {
            this.key = key;
        }
    }

    Node root;

    /**
     * 获取节点的高度
     */
    int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 获取两个整数中的较大值
     * @param a
     * @param b
     * @return
     */
    int max(int a, int b) {
        return Math.max(a, b);
    }

    /**
     * 对以节点y为根节点的子树进行右旋操作
     * @param y
     * @return
     */
    Node rightRotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        // 进行旋转操作
        x.right = y;
        y.left = t2;

        // 更新节点的高度
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // 返回新的根节点
        return x;
    }

    /**
     * 对以节点x为根节点的字数进行左旋操作
     * @param x
     * @return
     */
    Node leftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        // 左旋
        y.left = x;
        x.right = t2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    /**
     * 返回节点node的平衡因子
     * @param node
     * @return
     */
    int getBalance(Node node) {
        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    Node insert(Node node, int key) {

        // 1 向普通的二叉排序树中插入节点
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }
        // 2 更新祖先节点的高度
        node.height = max(height(node.left), height(node.right)) + 1;

        // 3 获取祖先节点的平衡因子，检查这个节点是否平衡
        int balance = getBalance(node);

        // 如果这个节点不平衡那么就有以下四种情况
        // 3.1 LL
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }
        // 3.2 RR
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }
        // 3.3 LR
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // 3.4 RL
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    Node deleteNode(Node root, int key) {
        // 1 执行标准的二叉排序树的删除操作
        if (root == null) {
            return root;
        }
        // 若待删除的节点的值小于根节点的值， 则待删除的节点在根节点的左子树中
        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.key) { // 否则待删除节点在根节点的右子树中
            root.right = deleteNode(root.right, key);
        } else { // 根节点为待删除节点
            if (root.left == null || root.right == null) {
                Node temp = null;
                if (root.left == null) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }

                // 叶子节点情况
                if (temp == null) {
                    temp = root;
                    root = null;
                } else { // 仅包含一个子节点的情况
                    // 复制临时变量temp中的内容
                    root = temp;
                }
            } else {//左子节点、右子节点均不为空
                // 获得根节点右子树中值最小的节点
                // 即中序遍历根节点的直接前驱节点
                Node temp = minValueNode(root.right);
                // 将中序遍历的直接前继节点的值复制给根节点
                root.key = temp.key;

                // 删除节点temp
                root.right = deleteNode(root.right, temp.key);
            }
        }
        // 若树中仅包含一个节点，则直接返回
        if (root == null) {
            return root;
        }

        // 更新当前节点的高度
        root.height = max(height(root.left), height(root.right)) + 1;

        // 获取当前节点的平衡因子，判断树的平衡性
        int balance = getBalance(root);

        // 若当前节点不平衡，则分以下四种情况进行处理
        // 3.1 LL
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }
        // 3.2 LR
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // 3.3 RR
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        // 3.4 RL
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
