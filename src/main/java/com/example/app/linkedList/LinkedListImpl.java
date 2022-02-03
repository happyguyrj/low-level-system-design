package com.example.app.linkedList;

public class LinkedListImpl<E> implements LinkedList<E>{

    Node<E> head;
    Node<E> tail;

    public LinkedListImpl() {
        head = null;
        tail = null;
    }

    @Override
    public void insertInEnd(E elementToBeInserted) {
        Node<E> nodeToBeInserted = new Node<>(elementToBeInserted);
        nodeToBeInserted.setNext(null);

        if (head == null) {
            insertInFront(elementToBeInserted);
            return;
        }

        tail.setNext(nodeToBeInserted);
        tail = tail.getNext();
    }

    @Override
    public void insertInFront(E elementToBeInserted) {
        Node<E> nodeToBeInserted = new Node<>(elementToBeInserted);
        nodeToBeInserted.setNext(head);

        if (head == null) {
            tail = nodeToBeInserted;
        }

        head = nodeToBeInserted;
    }

    @Override
    public boolean delete(E elementToBeDeleted) {
        Node<E> startNode = head;
        Node<E> previousNode = head;

        if (startNode == null) {
            System.out.println("Empty list");
            return false;
        }

        while (!startNode.getValue().equals(elementToBeDeleted)) {
            previousNode = startNode;
            startNode = startNode.getNext();

            if (startNode == null) {
                System.out.println("Node to be deleted does not exist");
                return false;
            }
        }

        previousNode.setNext(previousNode.getNext().getNext());
        return true;
    }

    @Override
    public E getFirstElement() {
        return head.getValue();
    }

    @Override
    public void printElement() {
        Node<E> startNode = head;
        while (startNode != null) {
            System.out.print(startNode.getValue() + " ");
            startNode = startNode.getNext();
        }
        System.out.println();
    }

    @Override
    public void insertAtPosition(E elementToBeInserted, int position) {
        Node<E> start = head;
        if (position == 0 ){
            insertInFront(elementToBeInserted);
            return;
        }

        int currentPosition = 0;
        if (checkEmptyList()){
            System.out.println("Cannot insert at position " + position);
            return;
        }

        while (start.getNext() != null && currentPosition++ < position) {
            start = start.getNext();
        }
        Node<E> nodeToBeInserted = new Node<>(elementToBeInserted);
        nodeToBeInserted.setNext(start.getNext());
        start.setNext(nodeToBeInserted);
    }

    @Override
    public boolean deleteAtPosition(int position) {
        if (position < 0) {
            System.out.println("Position to be deleted cannot be less than 0");
            return false;
        }
        Node<E> startNode = head;
        Node<E> previousNode = head;
        int currentPosition = 0;

        if (checkEmptyList()){
            System.out.println("Node to be deleted does not exist");
            return false;
        }

        while (currentPosition ++ < position) {
            previousNode = startNode;
            startNode = startNode.getNext();

            if (startNode == null) {
                System.out.println("Position to be deleted does not exist");
                return false;
            }
        }

        previousNode.setNext(startNode.getNext());
        return true;
    }

    private boolean checkEmptyList() {
        return head == null;
    }
}
