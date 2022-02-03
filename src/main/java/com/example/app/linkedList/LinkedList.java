package com.example.app.linkedList;

import java.util.Iterator;

public interface LinkedList<E> {

    void insertInEnd(E elementToBeInserted);
    void insertInFront(E elementToBeInserted);
    void insertAtPosition(E elementToBeInserted, int position);

    boolean delete(E elementToBeDeleted);
    boolean deleteAtPosition(int position);

    E getFirstElement();
    E getElementAtPosition(int position);
    Iterator<E> iterator();

    int size();

    void printElements();

    boolean isEmpty();

    boolean contains(E element);

    void clear();
}
