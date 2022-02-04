package com.example.app.sortingImpl;

import com.example.app.Comparator;
import com.example.app.Sort;

public class SelectionSortImpl<E> implements Sort<E> {

    @Override
    public E[] sort(E[] list, Comparator<? super E> comparator) {
        int n = list.length;
        int operations = 0;

        for (int i = 0; i < n-1; i++) {
            int minIndex = i;

            for (int j = i+1; j < n ; j++) {
                if (comparator.compare(list[j], list[minIndex]) > 0) {
                    minIndex = j;
                    operations++;
                }
            }

            E temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
        System.out.println("Sorted in " + operations + " steps by selection sort");
        return list;
    }
}
