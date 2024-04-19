package br.edu.ifpb.eda.doubly;

import br.edu.ifpb.eda.interfaces.ILinkedList;

public class LinkedList<T> implements ILinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<T> getNode(int index, int beginIndex, Node<T> begin) {
        Node<T> current = begin;
        for (int currentIndex = beginIndex; currentIndex < index; currentIndex++)
            current = current.next;
        for (int currentIndex = beginIndex; currentIndex > index; currentIndex--)
            current = current.previous;
        return current;
    }

    private Node<T> getNode(int index) {
        if (index < (size >> 1))
            return getNode(index, 0, this.head);
        return getNode(index, size - 1, this.tail);
    }

    @Override
    public void addLast(T element) {
        this.size++;

        this.tail = new Node<T>(element, this.tail, null);
        if (this.head == null)
            this.head = this.tail;
    }

    @Override
    public void addFirst(T element) {
        this.size++;

        this.head = new Node<T>(element, null, this.head);
        if (this.tail == null)
            this.tail = this.head;
    }

    @Override
    public void add(int index, T element) {
        this.size++;

        if (index == 0) {
            addFirst(element);
            return;
        }

        if (index == size() - 1) {
            addLast(element);
            return;
        }

        Node<T> current = getNode(index);
        new Node<T>(element, current.previous, current);
    }

    @Override
    public T getFirst() {
        return this.head.value;
    }

    @Override
    public T getLast() {
        return this.tail.value;
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        Node<T> current = getNode(index);
        T tmp = current.value;
        current.value = element;
        return tmp;
    }

    @Override
    public T removeFirst() throws IndexOutOfBoundsException {
        if (isEmpty())
            throw new IndexOutOfBoundsException();

        Node<T> first = this.head;
        this.head = first.next;
        if (this.head == null)
            this.tail = null;
        this.size--;

        return first.value;
    }

    @Override
    public T removeLast() throws IndexOutOfBoundsException {
        if (isEmpty())
            throw new IndexOutOfBoundsException();

        Node<T> last = this.tail;
        this.tail = last.previous;
        if (this.tail == null)
            this.head = null;
        this.size--;

        return last.value;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (index == 0)
            return removeFirst();
        if (index == size - 1)
            return removeLast();

        Node<T> current = getNode(index);
        Node<T> previous = current.previous;
        Node<T> next = current.next;

        previous.next = next;
        next.previous = previous;
        this.size--;

        return current.value;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder().append("[");

        for (Node<T> current = this.head; current != null; current = current.next)
            string.append(current.value.toString()).append(", ");

        return (isEmpty() ? string.append("]") : string.replace(string.length() - 2, string.length(), "]")).toString();
    }
}
