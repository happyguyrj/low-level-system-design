package com.example.app.linkedList;

public interface LinkedList<E> {

    void insertInEnd(E elementToBeInserted);
    void insertInFront(E elementToBeInserted);
    void insertAtPosition(E elementToBeInserted, int position);

    boolean delete(E elementToBeDeleted);
    boolean deleteAtPosition(int position);

    E getFirstElement();
    E getElementAtPosition(int position);

    int size();

    void printElement();

    boolean isEmpty();

    boolean contains(E element);

    void clear();
}
