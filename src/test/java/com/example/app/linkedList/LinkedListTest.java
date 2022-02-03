package com.example.app.linkedList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

class LinkedListTest {

	@Test
	void testInsertionInFront() {
		LinkedList<Integer> linkedList = new LinkedListImpl<>();
		linkedList.insertInFront(1);
		linkedList.insertInFront(2);
		linkedList.insertInFront(3);
		linkedList.insertInFront(4);

		linkedList.printElement();
	}

	@Test
	void testInsertionInEnd() {
		LinkedList<Integer> linkedList = new LinkedListImpl<>();
		linkedList.insertInEnd(1);
		linkedList.insertInEnd(2);
		linkedList.insertInEnd(3);
		linkedList.insertInEnd(4);

		linkedList.printElement();
	}

	@Test
	void testInsertionAtPosition() {
		LinkedList<Integer> linkedList = new LinkedListImpl<>();
		linkedList.insertAtPosition(2,3);
		linkedList.insertAtPosition(1,0);
		linkedList.insertAtPosition(2,1);
		linkedList.insertAtPosition(3,2);
		linkedList.insertAtPosition(4,1);

		linkedList.printElement();
	}

	@Test
	void testInsertion() {
		LinkedList<Integer> linkedList = new LinkedListImpl<>();
		linkedList.insertInFront(1);
		linkedList.insertInFront(2);
		linkedList.insertInFront(3);
		linkedList.insertInFront(4);
		linkedList.printElement();

		linkedList.insertInEnd(5);
		linkedList.insertInEnd(6);
		linkedList.insertInEnd(7);
		linkedList.printElement();

		linkedList.insertAtPosition(8,0);
		linkedList.insertAtPosition(9,1);
		linkedList.insertAtPosition(0,2);
		linkedList.insertAtPosition(-1,1);

		linkedList.printElement();
	}

	@Test
	void testDeleteElement() {
		LinkedList<Integer> linkedList = new LinkedListImpl<>();
		linkedList.insertInFront(1);
		linkedList.insertInFront(2);
		linkedList.insertInFront(3);
		linkedList.insertInFront(4);
		linkedList.insertInEnd(5);
		linkedList.insertInEnd(6);
		linkedList.insertInEnd(7);
		linkedList.insertAtPosition(8,0);
		linkedList.insertAtPosition(9,1);
		linkedList.insertAtPosition(0,2);
		linkedList.insertAtPosition(-1,1);

		Assert.isTrue(!linkedList.delete(10));
		Assert.isTrue(linkedList.delete(-1));
		linkedList.printElement();
	}

	@Test
	void testDeleteElementAtPosition() {
		LinkedList<Integer> linkedList = new LinkedListImpl<>();
		linkedList.insertInFront(1);
		linkedList.insertInFront(2);
		linkedList.insertInFront(3);
		linkedList.insertInFront(4);
		linkedList.insertInEnd(5);
		linkedList.insertInEnd(6);
		linkedList.insertInEnd(7);
		linkedList.insertAtPosition(8,0);
		linkedList.insertAtPosition(9,1);
		linkedList.insertAtPosition(0,2);
		linkedList.insertAtPosition(-1,1);

		Assert.isTrue(!linkedList.deleteAtPosition(20));
		Assert.isTrue(!linkedList.deleteAtPosition(-1));
		Assert.isTrue(linkedList.deleteAtPosition(5));
		linkedList.printElement();
	}
}
