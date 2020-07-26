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

        public SinglyLinkedListNode(T data, SinglyLinkedListNode next) {
            this.data = data;
            this.next = next;
        }

        public T remove() {
            T removedData = this.data;

            if (this.next == null) {
                this.data = null;
                this.next = null;
            } else {
                this.data = this.next.data;
                this.next = this.next.next;
            }

            return removedData;
        }
    }

    private SinglyLinkedListNode getNodeByIndex(int index) {
        if (this.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (index < 0 || index > this.size-1) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (this.size-1) + ". Provided: " + index);
        }

        SinglyLinkedListNode result = this.head;
        while(index > 0 && result.next != null) {
            result = result.next;
            index--;
        }

        return result;
    }

    // Check if Linked List is empty
    public boolean isEmpty() {
        return this.size == 0;
    }

    // Get length of Linked List
    public int size() {
        return this.size;
    }

    // Get element at the index position
    public T get(int index) {
        SinglyLinkedListNode result = this.getNodeByIndex(index);
        return result.data;
    }

    // Get data from the first element
    public T get() {
        if (this.head == null) {
            return null;
        }

        return this.head.data;
    }

    // Get data from the first element
    public T getFirst() {
        return get();
    }

    // Get data from the last element
    public T getLast() {
        if (this.tail == null) {
            return null;
        }

        return this.tail.data;
    }

    // Add data to an specific position
    public void add(int index, T data) {
        SinglyLinkedListNode nodeAtIndex = this.getNodeByIndex(index);
        SinglyLinkedListNode newNext = new SinglyLinkedListNode(nodeAtIndex.data, nodeAtIndex.next);
        nodeAtIndex.data = data;
        nodeAtIndex.next = newNext;
        this.size++;
    }

    // Append to the end
    public void add(T data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.next = newNode;
            this.tail = this.tail.next;
        }

        this.size++;
    }

    // Insert in the beginning
    public void push(T data) {
        head = new SinglyLinkedListNode(data, head);
        this.size++;
    }

    // Update the element at index
    public void set(int index, T data) {
        this.getNodeByIndex(index).data = data;
    }

    // Remove element at index
    public T remove(int index) {
        SinglyLinkedListNode nodeToRemove = this.getNodeByIndex(index);
        T removedData = nodeToRemove.remove();

        this.size--;
        return removedData;
    }

    // Remove first element (head)
    public T remove() {
        return remove(0);
    }

    // Alias to remove()
    public T pop() {
        return remove();
    }

    public T removeLast() {
        T removedData = tail.data;
        // Set new last element to the second to last element
        this.tail = this.getNodeByIndex(this.size-2);

        // remove old last element
        this.tail.next = null;

        this.size--;
        return removedData;
    }
}
