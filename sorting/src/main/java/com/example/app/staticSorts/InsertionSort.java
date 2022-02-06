package com.example.app.staticSorts;

import com.example.app.Comparable;

public class InsertionSort<E> {

    // impose an upper bound on type E, which states that E is guaranteed to implement the Comparable interface.
    public static <E extends Comparable<? super E>> E[] sort(E[] list) {
        int n = list.length;
        int operations = 0;

        for (int i=1; i<list.length; i++) {
            E key = list[i];
            int j = i-1;
            while (j>=0 && list[j].compareTo(key) > 0) {
                list[j+1] = list[j];
                j--;
                operations++;
            }
            list[j+1] = key;
        }
        System.out.println("Sorted in " + operations + " steps by static insertion sort");
        return list;
    }
}
