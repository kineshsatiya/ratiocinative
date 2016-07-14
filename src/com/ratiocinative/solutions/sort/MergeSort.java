package com.ratiocinative.solutions.sort;

import java.util.Random;

public class MergeSort<T extends Comparable<T>> {

    public void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(T[] arr, int low, int high) {
        if (high - low > 1) {
            int mid = (low + high) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    @SuppressWarnings("unchecked")
    private void merge(T[] arr, int low, int mid, int high) {
        Object[] aux = new Comparable[high - low + 1];
        int p = 0;
        int p1 = low;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= high) {
            int cmp = arr[p1].compareTo(arr[p2]);
            if (cmp <= 0) {
                aux[p] = arr[p1++];
            } else {
                aux[p] = arr[p2++];
            }
            p++;
        }

        while (p1 <= mid && p2 >= high) {
            aux[p++] = arr[p1++];
        }
        while (p2 <= high) {
            aux[p++] = arr[p2++];
        }

        for (int k = 0; k < aux.length; k++) {
            arr[k + low] = (T) aux[k];
        }
    }

    public static void main(String[] args) {
        MergeSort<Integer> mg = new MergeSort<>();
        int len = 6;
        Integer[] numbers = new Integer[len];
        Random r = new Random();
        for (int i = 0; i < len; i++) {
            numbers[i] = r.nextInt(100);
        }
        System.out.println("Before Sort");
        for (int i = 0; i < len; i++) {
            System.out.println(numbers[i].toString());
        }
        mg.sort(numbers);
        System.out.println("After Sort");
        for (int i = 0; i < len; i++) {
            System.out.println(numbers[i].toString());
        }
    }

}
