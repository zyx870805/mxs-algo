package com.xm.list;

public class CircularList {
    class Node {
        private Node next;
        private int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public void printList(Node head) {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.data);
                temp = temp.next;
            } while (temp != head);
        }
    }

    public Node addToEmpty(Node last, int data) {
        if (last != null) {
            return last;
        }
        Node temp = new Node(data);
        last = temp;
        temp.next = last;
        return last;
    }

    public Node addBegin(Node last, int data) {
        if (last == null) {
            return addToEmpty(last, data);
        }
        Node temp = new Node(data);
        temp.next = last.next;
        last.next = temp;
        return last;
    }

    public Node addEnd(Node last, int data) {
        if (last == null) {
            return addToEmpty(last, data);
        }
        Node temp = new Node(data);
        temp.next = last.next;
        last.next = temp;
        last = temp;
        return last;
    }

    public Node addAfter(Node last, int data, int item) {
        if (last == null) {
            return null;
        }

        Node temp, p;
        p = last.next;
        do {
            if (p.data == item) {
                temp = new Node(data);
                temp.next = p.next;
                p.next = temp;

                if (p == last) {
                    last = temp;
                }
                return last;
            }
            p = p.next;
        } while (p != last.next);
        System.out.println(item + " 不在链表中");
        return last;
    }

}