package com.example.app.linkedList;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedListImpl<Integer>();

        linkedList.insertInEnd(1);
        linkedList.insertInEnd(2);
        linkedList.insertInEnd(3);
        linkedList.insertInEnd(4);
        linkedList.insertInEnd(4);
        linkedList.insertInFront(0);
        linkedList.delete(3);


    }
}
