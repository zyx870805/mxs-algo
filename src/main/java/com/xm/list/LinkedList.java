package com.xm.list;

public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;
        public Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    public void insertAfter(Node prevNode, int newData) {
        if (prevNode == null) {
            System.out.println("指定節點不能爲空");
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public void append(int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next=null;
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    public void deleteNode(int key) {
        Node temp = head, prev = null;
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        prev.next = temp.next;
    }


    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.head = new Node(1);
        Node second = new Node(2);
        llist.head.next = second;
        Node third = new Node(3);
        second.next = third;

        llist.printList();
    }

}
