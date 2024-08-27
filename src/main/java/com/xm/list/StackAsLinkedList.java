package com.xm.list;

public class StackAsLinkedList {
    StackNode top;

    static class StackNode {
        int data;
        StackNode next;

        StackNode(int data) {
            this.data = data;
        }
    }

    public boolean iEmpty() {
        if (top == null) {
            return true;
        }
        return false;
    }

    public void push(int data) {
        StackNode newNode = new StackNode(data);
        if (top == null) {
            top = newNode;
        } else {
            StackNode temp = top;
            top = newNode;
            newNode.next = temp;
        }
        System.out.println(data + "已入棧");
    }

    public int pop() {
        int popped = Integer.MAX_VALUE;
        if (top == null) {
            System.out.println("棧爲空");
        } else {
            popped = top.data;
            top = top.next;
        }
        return popped;
    }
    

    public int peek() {
        int popped = Integer.MAX_VALUE;
        if (top == null) {
            System.out.println("棧爲空");
        } else {
            popped= top.data;
        }
        return popped;
    }

    public static void main(String[] args) {
        StackAsLinkedList stackAsLinkedList = new StackAsLinkedList();
        stackAsLinkedList.push(10);
        stackAsLinkedList.push(20);
        stackAsLinkedList.push(30);
        
        System.out.println(stackAsLinkedList.pop() + "出棧");
        System.out.println("棧頂元素是:" + stackAsLinkedList.peek());
    }
}