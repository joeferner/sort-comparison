package com.fernsroth;

public class QuickSort implements Sort {
    public void sort(long[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(long[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        // pick the pivot
        int middle = low + (high - low) / 2;
        long pivot = array[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                long temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j) {
            sort(array, low, j);
        }

        if (high > i) {
            sort(array, i, high);
        }
    }
}
