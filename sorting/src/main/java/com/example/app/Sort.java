package com.example.app;

public interface Sort<E> {

    E[] sort(E[] list, Comparator<? super E> comparator);
}
