package com.xm.list;

public class PriorityQueue {
    static class Node {
        int data;
        int priority;
        Node next;
    }
    
    static Node node = new Node();
    
    // 创建一个新节点
    static Node newNode(int d, int p) {
        Node temp = new Node();
        temp.data = d;
        temp.priority = p;
        temp.next = null;
        return temp;
    }
    
    // 返回头指针指向的值
    static int peek(Node head) {
        return head.data;
    }
    
    // 移除具有最高优先级的节点，即头节点
    static Node pop(Node head) {
        Node temp = head;
        head = head.next;
        return head;
    }
    
    // 根据优先级将新元素加入队列
    static Node push(Node head, int d, int p) {
        Node start = head;
        
        // 创建一个值为d， 优先级为p的新节点
        Node temp = newNode(d, p);
        // 如果新节点p比头节点的优先级高, 就将新节点插到头节点之前作为新的头节点
        if ((head.priority < p)) {
            temp.next = head;
            head = temp;
        } else {
            // 遍历单链表将新节点按照优先级插到正确的位置
            while (start.next != null && start.next.priority > p) {
                start = start.next;
            }
            temp.next = start.next;
            start.next = temp;
        }
        return head;
    }
    
    // 检查单链表是否为空
    static int isEmpty(Node head) {
        return head == null ? 1 : 0;
    }
}