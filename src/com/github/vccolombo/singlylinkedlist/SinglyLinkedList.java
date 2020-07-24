package com.github.vccolombo.singlylinkedlist;

public class SinglyLinkedList<T> {

    private T data = null;
    private SinglyLinkedList<T> next = null;

    public SinglyLinkedList() {

    }

    public T getData() {
        return data;
    }

    public SinglyLinkedList<T> getNext() {
        return next;
    }

    public void setData(T value) {
        data = value;
    }

    public void setNext(SinglyLinkedList<T> next) {
        this.next = next;
    }

    public SinglyLinkedList<T> append(T value) {
        // if head is null, insert here
        if (data == null) {
            data = value;
            return this;
        }

        SinglyLinkedList<T> newNode = new SinglyLinkedList<>();
        newNode.data = value;

        SinglyLinkedList<T> last = this;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;

        return last.next;
    }
}
