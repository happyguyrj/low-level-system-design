package com.example.app.cache.domain.node;

public class DoubleLinkedList<Key> {
    private int n;
    private FrequencyNode<Key> head;
    private FrequencyNode<Key> tail;

    public DoubleLinkedList() {
    }

    public void add(FrequencyNode<Key> node) {
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        n++;
    }

    public void remove(FrequencyNode<Key> node) {
        if (node.next == null)
            tail = node.prev;
        else
            node.next.prev = node.prev;

        if (head.key() == node.key())
            head = node.next;
        else node.prev.next = node.next;

        n--;
    }

    public FrequencyNode<Key> head() {
        return head;
    }

    public int size() {
        return n;
    }
}