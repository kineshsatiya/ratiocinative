package com.ratiocinative.solutions.sort;

public class InsertionSort {

    public void insertionSortASC(int[] arr) {
        if (arr != null && arr.length > 0) {
            for (int j = 1; j < arr.length; j++) {
                int key = arr[j];
                int i = j - 1;
                while (i >= 0 && key < arr[i]) {
                    arr[i + 1] = arr[i];
                    i--;
                }
                arr[i + 1] = key;
            }
        }
    }

    public void insertionSortDESC(int[] arr) {
        if (arr != null && arr.length > 0) {
            for (int j = 1; j < arr.length; j++) {
                int key = arr[j];
                int i = j - 1;
                while (i >= 0 && key > arr[i]) {
                    arr[i + 1] = arr[i];
                    i--;
                }
                arr[i + 1] = key;
            }
        }
    }

    public int findElementWithMaxInversions(int[] arr) {
        if (arr != null && arr.length > 0) {
            int maxInversionElement = arr[0];
            int currMax = 0;
            for (int j = 1; j < arr.length; j++) {
                int max = 0;
                int key = arr[j];
                int i = j - 1;
                while (i >= 0) {
                    if (key < arr[i]) {
                        max++;
                    }
                    i--;
                }

                if (max > currMax) {
                    currMax = max;
                    maxInversionElement = key;
                }
            }
            System.out.println("Max: " + currMax);
            return maxInversionElement;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 8, 6, 1};
        InsertionSort is = new InsertionSort();
        is.insertionSortDESC(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println(is.findElementWithMaxInversions(arr));
    }

}
