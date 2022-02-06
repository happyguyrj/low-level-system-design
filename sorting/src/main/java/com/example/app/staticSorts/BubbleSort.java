package com.example.app.staticSorts;

import com.example.app.Comparable;

public class BubbleSort<E> {

    // impose an upper bound on type E, which states that E is guaranteed to implement the Comparable interface.
    public static <E extends Comparable<? super E>> E[] sort(E[] list) {
        int n = list.length;
        int operations = 0;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    operations++;
                }
            }
        }
        System.out.println("Sorted in " + operations + " steps by static bubble sort");
        return list;
    }
}
