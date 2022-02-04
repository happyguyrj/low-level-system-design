package com.example.app;

public interface Comparator<T> {

    // lhs < rhs - comp.compare(lhs, rhs) < 0
    // lhs > rhs - comp.compare(lhs, rhs) > 0
    // lhs == rhs - comp.compare(lhs, rhs) == 0
    int compare(T a, T b);
}
