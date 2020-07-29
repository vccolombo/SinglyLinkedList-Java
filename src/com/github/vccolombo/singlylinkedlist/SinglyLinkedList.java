package com.github.vccolombo.singlylinkedlist;

public class SinglyLinkedList<T> {

    private Node head = null;
    private Node tail = null;
    private int size;

    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node getNodeByIndex(int index) {
        if (this.isEmpty()) throw new IllegalStateException("List is empty");
        if (index < 0 || index > this.size-1) throw new IndexOutOfBoundsException(
                "Index must be between 0 and " + (this.size-1) + ". Provided: " + index);

        Node result = this.head;
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
        Node result = this.getNodeByIndex(index);
        return result.data;
    }

    // Get data from the first element
    public T get() {
        if (this.isEmpty()) throw new IllegalStateException("List is empty");

        return this.head.data;
    }

    // Get data from the first element
    public T getFirst() {
        return get();
    }

    // Get data from the last element
    public T getLast() {
        if (this.isEmpty()) throw new IllegalStateException("List is empty");

        return this.tail.data;
    }

    // Add data to an specific position
    public void add(int index, T data) {
        Node nodeAtIndex = this.getNodeByIndex(index);
        Node newNext = new Node(nodeAtIndex.data, nodeAtIndex.next);
        nodeAtIndex.data = data;
        nodeAtIndex.next = newNext;
        this.size++;
    }

    // Append to the end
    public void add(T data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.next = newNode;
            this.tail = this.tail.next;
        }

        this.size++;
    }

    // Alias to add(T data)
    public void addLast(T data) {
        this.add(data);
    }

    // Insert in the beginning
    public void addFirst(T data) {
        if (this.isEmpty()) {
            head = tail = new Node(data, head);
        } else {
            head = new Node(data, head);
        }

        this.size++;
    }

    // Update the element at index
    public void set(int index, T data) {
        this.getNodeByIndex(index).data = data;
    }

    // Remove element at index
    public T remove(int index) {
        if (index < 0 || index > this.size-1) throw new IndexOutOfBoundsException(
                "Index must be between 0 and " + (this.size-1) + ". Provided: " + index);

        if (index == 0) return removeFirst();
        if (index == this.size-1) return removeLast();

        Node previousNode = this.getNodeByIndex(index-1);

        T removedData = previousNode.next.data;
        previousNode.next = previousNode.next.next;

        this.size--;
        return removedData;
    }

    // Remove first element (head)
    public T removeFirst() {
        if (this.isEmpty()) throw new IllegalStateException("List is empty");

        T removedData = head.data;
        head = head.next;
        this.size--;

        if (this.isEmpty()) tail = null;

        return removedData;
    }

    // Remove element at tail
    public T removeLast() {
        if (this.isEmpty()) throw new IllegalStateException("List is empty");

        if (this.size == 1) return removeFirst();

        T removedData = tail.data;
        // Set new last element to the second to last element
        this.tail = this.getNodeByIndex(this.size-2);

        // remove old last element
        this.tail.next = null;

        this.size--;
        return removedData;
    }

    // Empty list
    public void clear() {
        while (!this.isEmpty()) {
            this.removeFirst();
        }
    }
}
