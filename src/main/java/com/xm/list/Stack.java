package com.xm.list;

public class Stack {
    static final int MAX = 1000;
    int top;
    int[] arr = new int[MAX];
    
    boolean isEmpty() {
        return top < 0;
    }
    
    Stack() {
        top = -1;
    }
    
    boolean push(int x) {
        if (top >= (MAX - 1)) {
            System.out.println("棧上溢出");
            return false;
        } else {
            arr[++top] = x;
            System.out.println(x + "入棧");
            return true;
        }
    }
    
    int pop() {
        if (top < 0) {
            System.out.println("棧下溢出");
            return 0;
        } else {
            int x = arr[top--];
            return x;
        }
    }
    
    int peek() {
        if (top < 0) {
            System.out.println("棧下溢出");
            return 0;
        } else {
            int x = arr[top];
            return x;
        }
    }
    
    void print() {
        for(int i = top; i >= 0; i --) {
            System.out.print(" " + arr[i]);
        }
    }
    
    public static void main(String[] args){
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " 出棧");
        System.out.println("棧頂元素為: " + s.peek());
        System.out.print("當前棧中元素: ");
        s.print();
    }
}