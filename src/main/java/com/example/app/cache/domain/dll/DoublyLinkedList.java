package com.example.app.cache.domain.dll;

import com.example.app.cache.exception.InvalidDataException;

import java.util.Objects;

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
        return dummyHead.next == dummyTail;
    }

    public DoublyLinkedListNode<E> insertElementAtEnd(final E element) {
        if (Objects.isNull(element))
            throw new InvalidDataException("Element should not be null");
        final DoublyLinkedListNode<E> node = new DoublyLinkedListNode(element);
        insertNodeAtEnd(node);
        return node;
    }

    public void insertNodeAtEnd(final DoublyLinkedListNode<E> node) {
        final DoublyLinkedListNode<E> tailPrev = dummyTail.prev;
        dummyTail.prev = node;
        node.next = dummyTail;
        tailPrev.next = node;
        node.prev = tailPrev;
    }

    public void detachNode(final DoublyLinkedListNode<E> node) {
        if (Objects.nonNull(node)) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public DoublyLinkedListNode<E> getFirstNode() {
        if (isEmpty())
            return null;
        return dummyHead.next;
    }

    public DoublyLinkedListNode<E> getLastNode() {
        if (isEmpty())
            return null;
        return dummyTail.prev;
    }
}
