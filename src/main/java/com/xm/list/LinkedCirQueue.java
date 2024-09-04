package com.xm.list;

public class LinkedCirQueue {
    static class Node {
        int data;
        Node next;
    }
    
    static class Queue {
        Node front, rear;
    }
    
    // 创建循环队列并入队
    static void enQueue(Queue q, int value) {
        Node temp = new Node();
        temp.data = value;
        
        if (q.front == null) {
            q.front = temp;
        } else {
            q.rear.next = temp;
        }
        q.rear = temp;
        q.rear.next = q.front;
    }
    
    // 出队操作
    static int deQueue(Queue q) {
        if (q.front ==  null) {
            System.out.println("Queue is empty");
            return Integer.MAX_VALUE;
        }
        int value;
        if (q.front == q.rear) {
            value = q.front.data;
            q.front = null;
            q.rear = null;
        } else {
            Node temp = q.front;
            value = temp.data;
            q.front = q.front.next;
            q.rear.next = q.front;
        }
        return value;
    }
    
    // 打印循环队列中的元素
    static void displayQueue(Queue q) {
        Node temp = q.front;
        System.out.printf("\nElements in Circular Queue are: ");
        while (temp.next != q.front) {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.printf("%d", temp.data);
    }
    
    public static void main(String[] args){
      Queue q = new Queue();
      q.front = q.rear = null;
      enQueue(q, 10);
      enQueue(q, 20);
      enQueue(q, 30);
      displayQueue(q);
      System.out.printf("\nDequeue value = %d", deQueue(q));
      System.out.printf("\nDequeue value = %d", deQueue(q));
      displayQueue(q);
      enQueue(q, 15);
      enQueue(q, 25);
      displayQueue(q);
      
    }
}