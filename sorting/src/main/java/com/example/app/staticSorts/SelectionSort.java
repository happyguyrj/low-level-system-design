package com.example.app.staticSorts;

import com.example.app.Comparable;

public class SelectionSort<E> {

    public static <E extends Comparable<? super E>> E[] sort(E[] list) {
        int n = list.length;
        int operations = 0;

        for (int i = 0; i < n-1; i++) {
            int minIndex = i;

            for (int j = i+1; j < n ; j++) {
                if (list[j].compareTo(list[minIndex]) > 0) {
                    minIndex = j;
                    operations++;
                }
            }

            E temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
        System.out.println("Sorted in " + operations + " steps by static selection sort");
        return list;
    }
}
