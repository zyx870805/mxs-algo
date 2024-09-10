package com.xm.tree;

public class BinaryTree {
    class Node {
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

    public static void main(String[] args){
      BinaryTree binaryTree = new BinaryTree();
      binaryTree.root = new Node(1);
      binaryTree.root.left = new Node(2);
      binaryTree.root.right = new Node(4);
      binaryTree.root.left.right = new Node(3);
    }
}