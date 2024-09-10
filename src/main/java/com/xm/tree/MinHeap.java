package com.xm.tree;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[this.capacity];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (2 * i) + 1;
    }

    private int rightChild(int i) {
        return (2 * i) + 2;
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private void minHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;
        if (left < size && heap[left] < heap[i]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[i]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    public void insert(int element) {
        if (size == capacity) {
            System.out.println("Overflow");
            return;
        }
        size ++;
        int i = size - 1;
        heap[i] = element;
        while (i != 0 && heap[i] < heap[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public void updateKey(int i, int newVal) {
        heap[i] = newVal;
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public void deleteKey(int i) {
        updateKey(i, Integer.MIN_VALUE);
        removeMin();
    }

    public int removeMin() {
        if (size <= 0) {
            return Integer.MAX_VALUE;
        }
        if (size == 1) {
            size --;
            return heap[0];
        }
        int root = heap[0];
        heap[0] = heap[size - 1];
        size --;
        minHeapify(0);
        return root;
    }

    public int getMin() {
        return heap[0];
    }

    public void print() {
        for (int i = 0; i <= size / 2; i++) {
            System.out.println(" PARENT: " + heap[i] + " LEFT CHILD: " + heap[2 * i + 1] + " RIGHT CHILD: " + heap[2 * i + 2]);
        }
    }
}
