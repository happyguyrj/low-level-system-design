package com.example.app.sortingImpl;

import com.example.app.Comparator;
import com.example.app.Sort;

public class BubbleSortImpl<E> implements Sort<E> {

    @Override
    public E[] sort(E[] list, Comparator<? super E> comparator) {
        int n = list.length;
        int operations = 0;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    operations++;
                }
            }
        }
        System.out.println("Sorted in " + operations + " steps by bubble sort");
        return list;
    }
}
