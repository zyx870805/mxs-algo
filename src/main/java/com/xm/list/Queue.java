package com.xm.list;

public class Queue {
    int front, rear, size;
    int capacity;
    int[] array;
    
    public Queue(int capacity) {
        this.capacity = capacity;
        this.front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }
    
    public boolean isFull(Queue queue) {
        return queue.size == queue.capacity;
    }
    
    public boolean isEmpty(Queue queue) {
        return queue.size == 0;
    }
    
    public void enquuue(int item) {
        if (isFull(this)) {
            return;
        }
        
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
        System.out.println(item + " enqueued to queue");
    }
    
    public int dequeue() {
        if (isEmpty(this)) {
            return Integer.MAX_VALUE;
        }
        
        int item = this.array[front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        System.out.println( item + "dequeue to queue");
        return item;
    }
    public int front() {
        if (isEmpty(this)) {
            return Integer.MAX_VALUE;
        }
        return this.array[this.front];
    }
    
    public int rear() {
        if (isFull(this)) {
            return Integer.MAX_VALUE;
        }
        
        return this.array[this.rear];
    }
    
    public static void main(String[] args){
      Queue queue = new Queue(1000);
      queue.enquuue(10);
      queue.enquuue(20);
      queue.enquuue(30);
      queue.enquuue(40);
      
      System.out.println(queue.dequeue() + "出隊");
      System.out.println("對頭元素" + queue.front());
      System.out.println("隊尾元素" + queue.rear());
    }
    
    
}