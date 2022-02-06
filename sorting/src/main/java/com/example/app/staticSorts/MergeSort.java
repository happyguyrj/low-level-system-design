package com.example.app.staticSorts;

import com.example.app.Comparable;

public class MergeSort<E> {

    // impose an upper bound on type E, which states that E is guaranteed to implement the Comparable interface.
    public static <E extends Comparable<? super E>> E[] sort(E[] list) {
        int n = list.length;
        int operations = 0;


        System.out.println("Sorted in " + operations + " steps by static merge sort");
        return list;
    }
}
