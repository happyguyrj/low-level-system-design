package com.example.app.staticSorts;

import com.example.app.Comparable;

public class HeapSort<E> {

    // impose an upper bound on type E, which states that E is guaranteed to implement the Comparable interface.
    public static <E extends Comparable<? super E>> E[] sort(E[] list) {
        int n = list.length;
        int operations = 0;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(list, n, i);

        for (int i = n - 1; i > 0; i--) {
            E temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            heapify(list, i, 0);
        }

        System.out.println("Sorted by static heap sort");
        return list;
    }

    private static<E extends Comparable<? super E>> void heapify(E arr[], int n, int i ) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l].compareTo(arr[largest]) > 0)
            largest = l;

        if (r < n && arr[r].compareTo(arr[largest]) > 0)
            largest = r;

        if (largest != i) {
            E swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}
