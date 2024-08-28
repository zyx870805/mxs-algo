package com.xm.list;

public class QueueAsLinked {
    class QNode {
        int key;
        QNode next;
        
        public QNode(int key) {
            this.key = key;
        }
    }
    
    QNode front, rear;
    
    public QueueAsLinked() {
    }
    
    public void enqueue(int key) {
        QNode temp = new QNode(key);
        
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
        
        this.rear.next = temp;
        this.rear = temp;
    }
    
    public int dequeue() {
        if (this.front == null) {
            return Integer.MAX_VALUE;
        }
        int result = this.front.key;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        return result;
    }
    
    public static void main(String[] args){
      QueueAsLinked queueAsLinked = new QueueAsLinked();
      queueAsLinked.enqueue(10);
      queueAsLinked.enqueue(20);
      queueAsLinked.dequeue();
      queueAsLinked.dequeue();
      queueAsLinked.enqueue(30);
      queueAsLinked.enqueue(40);
      queueAsLinked.enqueue(50);
      queueAsLinked.dequeue();
      System.out.println("對頭元素為: " + queueAsLinked.front.key);
      System.out.println("隊尾元素為: " + queueAsLinked.rear.key);
    }
}