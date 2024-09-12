package com.xm.tree;

public class PriorityQueueHeap {
    static int[] heap = new int[100];
    static int size = -1;

    static int parent(int i) {
        return (i - 1) / 2;
    }

    static int leftChild(int i) {
        return (2 * i) + 1;
    }

    static int rightChild(int i) {
        return (2 * i ) + 2;
    }

    static void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    static void shiftUp(int i) {
        while(i > 0 && heap[parent(i)] < heap[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    static void shiftDown(int i) {
        int maxIndex = i;

        int l = leftChild(i);

        if (l <= size && heap[l] > heap[maxIndex]) {
            maxIndex = l;
        }

        int r = rightChild(i);
        if (r <= size && heap[r] > heap[maxIndex]) {
            maxIndex = r;
        }

        if (i != maxIndex) {
            swap(i, maxIndex);
            shiftDown(maxIndex);
        }
    }

    static void insert(int p) {
        size = size + 1;
        heap[size] = p;
        shiftUp(size);
    }

    static int extractMax() {
        int result = heap[0];
        heap[0] = heap[size];
        size = size - 1;
        shiftDown(0);
        return result;
    }

    static void changePriority(int i, int p) {
        int oldP = heap[i];
        heap[i] = p;
        if (p > oldP) {
            shiftUp(i);
        } else {
            shiftDown(i);
        }
    }

    static int getMax() {
        return heap[0];
    }

    static void remove(int i) {
        heap[i] = getMax() + 1;
        shiftUp(i);
        extractMax();
    }


}
