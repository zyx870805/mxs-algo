package com.xm.list;

public class DoubleLinkedList {
    Node head;
    
    class Node {
        int data;
        Node pre;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    
    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        newNode.pre = null;
        
        if (head != null) {
            head.pre = newNode;
        }
        head = newNode;
    }
    
    public void insertAfter(Node preNode, int newData) {
        if (preNode == null) {
            System.out.println("指定的节点为null");
            return;
        }
        Node newNode = new Node(newData);
        newNode.pre = preNode;
        newNode.next = preNode.next;
        
        preNode.next = newNode;
        if (newNode.next != null) {
            preNode.next.pre = newNode;
        }
        
    }
}