package com.github.vccolombo.singlylinkedlist;

public class SinglyLinkedList<T> {

    private SinglyLinkedListNode head = null;
    private SinglyLinkedListNode tail = null;
    private int size;

    private class SinglyLinkedListNode {
        private T data;
        private SinglyLinkedListNode next;

        public SinglyLinkedListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Get length of Linked List
    public int size() {
        return this.size;
    }

    // Get element at the index position
    public T get(int index) {
        SinglyLinkedListNode result = this.head;
        while(index > 0 && result != null) {
            result = result.next;
            index--;
        }

        if (result == null) {
            return null;
        }

        return result.data;
    }

    // Get data from head (first element)
    public T get() {
        return this.head.data;
    }

    // Get data from head (first element)
    public T getFirst() {
        return get();
    }

    public T getLast() {
        return this.tail.data;
    }

    // Append to end
    public void add(T data) {
        this.size++;

        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
            return;
        }

        this.tail.next = newNode;
        this.tail = this.tail.next;
    }
}
