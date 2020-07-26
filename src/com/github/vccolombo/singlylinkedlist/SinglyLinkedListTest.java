package com.github.vccolombo.singlylinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    public void create_noElements_empty() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();

        assertNull(linkedList.get());
        assertNull(linkedList.getFirst());
        assertNull(linkedList.getLast());
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
    }

    @Test
    public void add_multipleElements_AllMustBeAdded() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.add("Hello World");
        linkedList.add("42");
        linkedList.add("Hayasaka best girl");

        assertEquals("Hello World", linkedList.get(0));
        assertEquals("42", linkedList.get(1));
        assertEquals("Hayasaka best girl", linkedList.get(2));
        assertEquals(3, linkedList.size());
    }

    @Test
    public void add_elementAtSpecificIndex_mustBeInsertedInCorrectLocation() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(5);

        linkedList.add(0, 0);
        linkedList.add(3, 3);

        assertEquals(0, linkedList.get(0));
        assertEquals(3, linkedList.get(3));
    }

    @Test
    public void add_ifIndexIsOutOfBounds_throwOutOfBoundsException() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(42);

        IndexOutOfBoundsException e;
        e = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(-1, 27));
        assertEquals("Index must be between 0 and 0. Provided: -1", e.getMessage());

        e = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(2, 27));
        assertEquals("Index must be between 0 and 0. Provided: 2", e.getMessage());
    }

    @Test
    public void isEmpty_ifNotEmpty_mustBeFalse() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(42);

        assertFalse(linkedList.isEmpty());
    }

    @Test
    public void push_multipleElements_firstElementMustBeTheLastPushed() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.push(2);
        linkedList.push(1);
        linkedList.push(0);

        assertEquals(0, linkedList.getFirst());
    }

    @Test
    public void push_multipleElements_secondElementMustBeTheSecondToLastPushed() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.push(2);
        linkedList.push(1);
        linkedList.push(0);

        assertEquals(1, linkedList.get(1));
    }

    @Test
    public void set_replaceAnElement_mustReplaceTheCorrectElement() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(0);
        linkedList.add(42);
        linkedList.add(2);

        linkedList.set(1, 1);

        assertEquals(0, linkedList.get(0));
        assertEquals(1, linkedList.get(1));
        assertEquals(2, linkedList.get(2));
    }

    @Test
    public void set_listIsEmpty_throwIllegalStateException() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> linkedList.set(0, 1));

        assertEquals("List is empty", e.getMessage());
    }

    @Test
    public void set_replaceAnElementOutOfBounds_throwOutOfBoundsException() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(0);
        linkedList.add(42);
        linkedList.add(2);

        IndexOutOfBoundsException e1 = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set(3, 1));
        IndexOutOfBoundsException e2 = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set(-1, 1));

        assertEquals("Index must be between 0 and 2. Provided: -1", e2.getMessage());
        assertEquals("Index must be between 0 and 2. Provided: 3", e1.getMessage());
    }

    @Test
    public void get_ifMultipleElementsInList_mustGetTheCorrectIndex() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.add("Hello");
        linkedList.add("World");
        linkedList.add("Hayasaka best girl");

        assertEquals("World", linkedList.get(1));
    }

    @Test
    public void getFirst_ifMultipleElementsInList_mustGetTheFirstElement() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.add("Hello");
        linkedList.add("World");
        linkedList.add("Hayasaka best girl");

        assertEquals("Hello", linkedList.getFirst());
    }

    @Test
    public void getLast_ifMultipleElementsInList_mustGetTheLastElement() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.add("Hello");
        linkedList.add("World");
        linkedList.add("Hayasaka best girl");

        assertEquals("Hayasaka best girl", linkedList.getLast());
    }

    @Test
    public void get_elementOutOfBounds_throwOutOfBoundsException() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
        linkedList.add("Hello");
        linkedList.add("World");

        IndexOutOfBoundsException e1 = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(2));
        IndexOutOfBoundsException e2 = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));

        assertEquals("Index must be between 0 and 1. Provided: 2", e1.getMessage());
        assertEquals("Index must be between 0 and 1. Provided: -1", e2.getMessage());
    }

    @Test
    public void removeFirst_listIsNotEmpty_mustRemoveAndReturnTheFirstElement() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(42);
        linkedList.add(27);
        linkedList.add(18);

        Integer element = linkedList.remove();

        assertEquals(42, element);
        assertEquals(27, linkedList.getFirst());
        assertEquals(2, linkedList.size());
    }

    @Test
    public void removeFirst_listWithOneElement_newHeadMustBeNull() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(42);

        linkedList.remove();

        assertNull(linkedList.get());
    }

    @Test
    public void removeFirst_listIsEmpty_mustThrowIllegalStateException() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        IllegalStateException e = assertThrows(IllegalStateException.class, linkedList::remove);

        assertEquals("List is empty", e.getMessage());
    }

    @Test
    public void remove_elementInTheMiddle_mustRemoveCorrectElement() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(42);
        linkedList.add(27);
        linkedList.add(18);

        Integer element = linkedList.remove(1);

        assertEquals(27, element);
        assertEquals(42, linkedList.getFirst());
        assertEquals(18, linkedList.getLast());
        assertEquals(18, linkedList.get(1));
        assertEquals(2, linkedList.size());
    }

    @Test
    public void remove_elementInTheBeginning_mustRemoveCorrectElement() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(42);

        Integer element = linkedList.remove(0);

        assertEquals(42, element);
        assertNull(linkedList.getFirst());
        assertNull(linkedList.getLast());
        assertEquals(0, linkedList.size());
    }

    @Test
    public void remove_elementInTheEnd_mustRemoveCorrectElement() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(42);
        linkedList.add(27);
        linkedList.add(18);

        Integer element = linkedList.remove(2);

        assertEquals(18, element);
        assertEquals(42, linkedList.getFirst());
        assertEquals(27, linkedList.getLast());
        assertEquals(27, linkedList.get(1));
        assertEquals(2, linkedList.size());
    }

    @Test
    public void removeLast_listHasMultipleValues_mustRemoveTheLastElement() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(42);
        linkedList.add(27);
        linkedList.add(18);

        Integer element = linkedList.removeLast();

        assertEquals(18, element);
        assertEquals(42, linkedList.getFirst());
        assertEquals(27, linkedList.getLast());
        assertEquals(2, linkedList.size());
    }

    @Test
    public void clear_listWithMultipleValues_mustClearTheList() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(42);
        linkedList.add(27);
        linkedList.add(18);

        linkedList.clear();

        assertNull(linkedList.getFirst());
        assertNull(linkedList.getLast());
        assertEquals(0, linkedList.size());
    }
}