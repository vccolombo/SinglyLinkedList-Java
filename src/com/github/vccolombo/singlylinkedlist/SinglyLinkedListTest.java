package com.github.vccolombo.singlylinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {
    @Test
    public void dataIsNullOnLinkedListCreation() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        assertNull(linkedList.getData());
    }

    @Test
    public void nextIsNullOnLinkedListCreation() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        assertNull(linkedList.getNext());
    }

    @Test
    public void setDataInLinkedListNode() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        Integer value = 42;
        linkedList.setData(value);
        assertEquals(value, linkedList.getData());
    }

    @Test
    public void setNextInLinkedListNode() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> next = new SinglyLinkedList<>();
        linkedList.setNext(next);

        assertEquals(next, linkedList.getNext());
    }

    @Test
    public void InsertFirstNodeInLinkedList() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        Integer value = 42;
        linkedList.append(value);

        assertEquals(value, linkedList.getData());
    }

    @Test
    public void InsertTwoNodesMustNotChangeFirstNodeData() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.append(1);
        linkedList.append(2);

        assertEquals(1, linkedList.getData());
    }

    @Test
    public void InsertMultipleNodes() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);

        assertEquals(3, linkedList.getNext().getNext().getData());
    }
}