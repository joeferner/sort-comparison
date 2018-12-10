package com.fernsroth;

public class MergeSort implements Sort {
    public void sort(long[] array) {
        sort(array, 0, array.length);
    }

    private static void sort(long[] array, int low, int high) {
        if (low < high - 1) {
            int mid = (low + high) / 2;
            sort(array, low, mid);
            sort(array, mid, high);
            merge(array, low, mid, high);
        }
    }

    private static void merge(long[] array, int low, int mid, int high) {
        int leftIndex = low;
        int rightIndex = mid;
        int midIndex = mid;
        for (int i = low; i < high; i++) {
            if ((rightIndex < high && array[leftIndex] < array[rightIndex])
                    && (midIndex < high && array[leftIndex] < array[midIndex])) {
                leftIndex++;
            } else if ((rightIndex < high && array[rightIndex] < array[leftIndex])
                    && (midIndex < high && array[rightIndex] <= array[midIndex])) {
                long temp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = temp;

                leftIndex++;
                rightIndex++;
                if (midIndex <= leftIndex) {
                    midIndex++;
                }
            } else if (midIndex < high && array[midIndex] < array[leftIndex]) {
                long temp = array[leftIndex];
                array[leftIndex] = array[midIndex];
                array[midIndex] = temp;

                leftIndex++;
                if (midIndex <= leftIndex) {
                    midIndex++;
                }
            }
        }
    }
}
