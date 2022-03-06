package com.example.app.cache;

import com.example.app.cache.domain.dll.DoublyLinkedList;
import com.example.app.cache.domain.dll.DoublyLinkedListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {

    @Test
    void testDllNodesAddition() {
        DoublyLinkedListNode<Integer> node1 = new DoublyLinkedListNode<>(1);
        DoublyLinkedListNode<Integer> node2 = new DoublyLinkedListNode<>(2);
        DoublyLinkedListNode<Integer> node3 = new DoublyLinkedListNode<>(3);
        DoublyLinkedListNode<Integer> node4 = new DoublyLinkedListNode<>(4);

        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        dll.insertNodeAtEnd(node1);
        verifyDLL(dll, List.of(1));

        dll.insertNodeAtEnd(node2);
        verifyDLL(dll, List.of(1, 2));

        dll.insertNodeAtEnd(node3);
        verifyDLL(dll, List.of(1, 2, 3));

        dll.insertNodeAtEnd(node4);
        verifyDLL(dll, List.of(1, 2, 3, 4));
    }

    void verifyDLL(DoublyLinkedList<Integer> dll, List<Integer> expectedListElements) {
        assertEquals(expectedListElements.get(expectedListElements.size() - 1), dll.getLastNode().getElement());
        assertEquals(expectedListElements.get(0), dll.getFirstNode().getElement());

        DoublyLinkedListNode<Integer> currentNode = dll.getFirstNode();
        for (Integer expectedListElement : expectedListElements) {
            assertNotNull(currentNode);
            assertEquals(expectedListElement, currentNode.getElement());
            currentNode = currentNode.getNext();
        }
        assertNull(currentNode.getNext());
    }
}