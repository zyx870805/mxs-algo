package com.xm.tree;

public class BinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    Node root;

    BinaryTree(int data) {
        root = new Node(data);
    }

    BinaryTree() {
        root = null;
    }


    void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + "->");
        preorder(node.left);
        preorder(node.right);
    }

    void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + "->");
        inorder(node.right);
    }

    void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + "->");
    }


    public Node search(Node root, int key) {
        //如果根节点为空或者根节点的值和待查找的值相同，则返回根节点
        if (root == null || root.data == key) {
            return root;
        }
        // 如果待查找的值大于根节点的值，则递归查找根节点右子树中的节点
        if (key > root.data) {
            return search(root.right, key);
        }
        // 若待查找的值小于根节点的值，则递归查找根节点左子树中的节点
        return search(root.left, key);
    }

    public Node insert(Node root, int key) {
        // 若树为空则返回一个新节点
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key > root.data) {// 若插入节点大于当前节点的值，则递归判断右子树中的节点
            root.right = insert(root.right, key);
        } else if (key < root.data){  // 若插入的节点的值小于当前节点的值，则递归判断左子树中的节点
            root.left = insert(root.left, key);
        }
        return root;
    }

    public Node deleteNode(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        else if(key > root.data) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleteNode(root.right, root.data);

//            root.data = maxValue(root.left);
//            root.left = deleteNode(root.left, root.data);
        }
        return root;
    }

    public int maxValue(Node root) {
        int maxv = root.data;
        while (root.right != null) {
            maxv = root.right.data;
            root = root.right;
        }
        return maxv;
    }

    public int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }



    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(4);
        binaryTree.root.left.right = new Node(3);
    }


}