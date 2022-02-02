package com.example.app.cache.domain;

public class DoublyLinkedList<E> {

    private final DoublyLinkedListNode<E> dummyHead;
    private final DoublyLinkedListNode<E> dummyTail;

    public DoublyLinkedList() {
        this.dummyHead = new DoublyLinkedListNode<>(null);
        this.dummyTail = new DoublyLinkedListNode<>(null);
        this.dummyHead.next = dummyTail;
        this.dummyTail.prev = dummyHead;
    }

    public boolean isEmpty() {
        return true;
    }

    public void insertNodeAtEnd(final DoublyLinkedListNode<E> node) {

    }

    public DoublyLinkedListNode<E> insertElementAtEnd(final E element) {
        return null;
    }

    public void detachNode(final DoublyLinkedListNode<E> node) {

    }

    public DoublyLinkedListNode<E> getFirstNode() {
        return null;
    }

    public DoublyLinkedListNode<E> getLastNode() {
        return null;
    }
}
