package com.example.app.cache.domain;

public class DoublyLinkedListNode<E> {

    E element;
    DoublyLinkedListNode<E> prev;
    DoublyLinkedListNode<E> next;

    public DoublyLinkedListNode(E element) {
        this.element = element;
        this.prev = null;
        this.next = null;
    }

    public E getElement() {
        return element;
    }

    public DoublyLinkedListNode<E> getPrev() {
        return prev;
    }

    public DoublyLinkedListNode<E> getNext() {
        return next;
    }
}
