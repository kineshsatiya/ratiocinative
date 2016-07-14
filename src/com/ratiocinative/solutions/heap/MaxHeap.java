package com.ratiocinative.solutions.heap;

public class MaxHeap {


    private int[] arr;
    private int heapSize;
    private int capacity;

    public MaxHeap(int c) {
        capacity = c;
        arr = new int[c];
        heapSize = 0;
    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return (i * 2) + 1;
    }

    private int right(int i) {
        return (i * 2) + 2;
    }

    private void heapify(int[] a, int i, int size) {
        int largest = i;
        int left = left(i);
        if (left < size && a[left] > a[largest]) {
            largest = left;
        }
        int right = right(i);
        if (right < size && a[right] > a[largest]) {
            largest = right;
        }

        if (largest != i) {
            int tmp = a[i];
            a[i] = a[largest];
            a[largest] = tmp;
            heapify(a, largest, size);
        }
    }

    public void buildMaxHeap() {
        for (int i = (heapSize / 2); i >= 0; i--) {
            heapify(arr, i, heapSize);
        }
    }

    public void sort() {
        buildMaxHeap();
        int size = heapSize;
        for (int i = heapSize - 1; i > 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            size--;
            heapify(arr, 0, size);
        }
    }

    public void insert(int i) {
        if (heapSize < capacity) {
            arr[heapSize++] = i;
        } else {
            throw new IllegalStateException("increase the heap size");
        }
    }

    public void printHeap() {
        for (int i = 0; i < heapSize; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(4);
        heap.insert(1);
        heap.insert(3);
        heap.insert(2);
        heap.insert(16);
        heap.insert(9);
        heap.insert(10);
        heap.printHeap();
        heap.buildMaxHeap();
        System.out.println("max heap built");
        heap.printHeap();
        heap.sort();
        System.out.println("calling sort");
        heap.printHeap();

    }
}
