package com.github.vccolombo.singlylinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    public void addFirstElement() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.add("Hello World");

        assertEquals("Hello World", linkedList.get());
    }

    @Test
    public void addTwoElementsAndCheckTheFirst() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.add("Hello World");
        linkedList.add("42");

        assertEquals("Hello World", linkedList.getFirst());
    }

    @Test
    public void addTwoElementsAndCheckTheSecond() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.add("Hello World");
        linkedList.add("42");

        assertEquals("42", linkedList.get(1));
    }

    @Test
    public void addMultipleElementsAndCheckTheLast() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.add("Hello World");
        linkedList.add("42");
        linkedList.add("My nose is perfect");
        linkedList.add("Hayasaka best girl");

        assertEquals("Hayasaka best girl", linkedList.getLast());
    }

    @Test
    public void addMultipleElementsAndCheckTheSize() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        assertEquals(4, linkedList.size());
    }
}