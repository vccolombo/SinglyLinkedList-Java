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
        linkedList.push(2);
        linkedList.add(3);
        linkedList.add(1, 4);

        assertEquals(4, linkedList.size());
    }

    @Test
    public void addElementAtSpecificIndex() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(4);

        linkedList.add(2, 2);

        assertEquals(2, linkedList.get(2));
    }

    @Test
    public void throwOutOfBoundsExceptionIfAddIndexIsNegative() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(42);

        IndexOutOfBoundsException e = assertThrows(
                IndexOutOfBoundsException.class, () -> linkedList.add(-1, 27));

        assertEquals("Index must be between 0 and 1. Provided: -1", e.getMessage());
    }

    @Test
    public void throwOutOfBoundsExceptionIfAddIndexIsGreaterThanSize() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(42);

        IndexOutOfBoundsException e = assertThrows(
                IndexOutOfBoundsException.class, () -> linkedList.add(3, 27));

        assertEquals("Index must be between 0 and 1. Provided: 3", e.getMessage());
    }

    @Test
    public void getMustReturnNullIfEmpty() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        assertNull(linkedList.get());
    }

    @Test
    public void getFirstMustReturnNullIfEmpty() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        assertNull(linkedList.getFirst());
    }

    @Test
    public void getLastMustReturnNullIfEmpty() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        assertNull(linkedList.getLast());
    }

    @Test
    public void isEmptyMustBeTrueIfEmpty() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void isEmptyMustBeFalseIfNotEmpty() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(42);

        assertFalse(linkedList.isEmpty());
    }

    @Test
    public void pushToBeginningAndGetFirstElement() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.push(2);
        linkedList.push(1);
        linkedList.push(0);

        assertEquals(0, linkedList.getFirst());
    }

    @Test
    public void pushToBeginningAndGetSecondElement() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.push(2);
        linkedList.push(1);
        linkedList.push(0);

        assertEquals(1, linkedList.get(1));
    }

    @Test
    public void replaceAnElement() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(0);
        linkedList.add(42);
        linkedList.add(2);

        linkedList.set(1, 1);

        assertEquals(1, linkedList.get(1));
    }

    @Test
    public void TryToReplaceAnElementOutOfBounds() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(0);
        linkedList.add(42);
        linkedList.add(2);

        IndexOutOfBoundsException e = assertThrows(
                IndexOutOfBoundsException.class, () -> linkedList.set(27, 1));

        assertEquals("Index must be between 0 and 2. Provided: 27", e.getMessage());
    }
}