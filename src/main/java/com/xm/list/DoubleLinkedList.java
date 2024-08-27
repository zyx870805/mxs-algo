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

    public void append(int newData) {
        Node newNode = new Node(newData);
        Node last = head;
        if (head == null) {
            head = newNode;
            return;
        }
        while(last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.pre = last;
    }

    public void insertBefore(Node nextNode, int newData) {
        if (nextNode == null) {
            System.out.println("nextNode 不能为null");
            return;
        }
        Node newNode = new Node(newData);
        newNode.pre = nextNode.pre;
        nextNode.pre = newNode;
        newNode.next = nextNode;
        if (newNode.pre != null) {
            newNode.pre.next = newNode;
        } else {
            head = newNode;
        }
    }

    public void deleteNode(Node head, Node del) {
        if (head == null || del == null) {
            return;
        }
        if (head == del) {
            head = del.next;
        }
        if (del.next != null) {
            del.next.pre = del.pre;
        }
        if (del.pre != null) {
            del.pre.next = del.next;
        }
    }

    public void printList(Node head) {
        Node node = head;
        while(node != null) {
            System.out.print(node.data);
            node  = node.next;
        }
    }

    
}