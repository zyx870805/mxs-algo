package com.xm.list;

import java.util.ArrayList;

public class CircularQueue {
    /**
     * size 表示队列容量
     * front 表示队头指针
     * rear 表示对尾指针
     */
    private int size, front, rear;

    // 用于模拟队列的数组
    private ArrayList<Integer> queue = new ArrayList<>();

    // 构造函数初始化
    CircularQueue(int size) {
        this.size = size;
        this.front = this.rear = -1;
    }

    // 入队操作
    public void enQueue(int data) {
        // 判断队列是否已满
        if ((front == 0 && rear == size - 1) ||
            (rear == (front - 1) % (size - 1))) {
            System.out.println("Queue is Full");
        } else if (front == -1) { // 队列为空
            front = 0;
            rear = 0;
            queue.add(rear, data);
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
            queue.set(rear, data);
        } else {
            rear = rear + 1;
            if (front <= rear) {
                queue.add(rear, data);
            } else {
                queue.set(rear, data);
            }
        }
    }

    // 出队操作
    public int deQueue() {
        int temp;

        // 队列为空
        if (front == -1) {
            System.out.println("Queue is Empty");
            return -1;
        }
        temp = queue.get(front);
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front = front + 1;
        }
        return temp;
    }

    //  遍历并打印队列中的元素
    public void displayQueue() {
        // 队列为空
        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }
        // 如果rear < size 或 read >= front
        System.out.print("循环队列中的元素为：");
        if (rear >= front) {
            for (int i = front; i <= rear; i++) {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        } else { // rear >= size
            // 打印front 到 size - 1 的元素
            for (int i = front; i < size; i++) {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            // 打印0到rear的元素
            for (int i = 0; i <= rear; i++) {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enQueue(10);
        q.enQueue(20);
        q.enQueue(30);
        q.enQueue(40);

        q.displayQueue();

        int x = q.deQueue();
        if (x != -1) {
            System.out.print("出队元素为：");
            System.out.println(x);
        }
        x = q.deQueue();
        if (x != -1) {
            System.out.print("出队元素为：");
            System.out.println(x);
        }
        q.displayQueue();
        q.enQueue(9);
        q.enQueue(25);
        q.enQueue(56);
        
        q.displayQueue();
        
        q.enQueue(25);
    }
}