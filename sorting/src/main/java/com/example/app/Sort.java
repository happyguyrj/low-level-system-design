package com.example.app;

public interface Sort<E> {

    // to assure Java that we are passing it a comparator that is defined on any supertype of E
    //• We do so by giving a lower bound for the argument.
    E[] sort(E[] list, Comparator<? super E> comparator);
}
