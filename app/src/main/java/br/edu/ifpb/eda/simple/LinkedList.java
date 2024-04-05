package br.edu.ifpb.eda.simple;

import br.edu.ifpb.eda.interfaces.ILinkedList;

public class LinkedList<T> implements ILinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
    }

    private Node<T> getNode(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node<T> current = this.head;
        for (int count = 0; count < index; count++)
            current = current.next;
        return current;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public void addLast(T element) {
        Node<T> current = this.head;

        if (current == null) {
            this.head = new Node<T>(element);
            return;
        }
        this.size++;

        while (current.next != null)
            current = current.next;
        current.next = new Node<T>(element);
    }

    @Override
    public void addFirst(T element) {
        this.size++;
        this.head = new Node<T>(element, this.head);
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException {
        if (index == 0) {
            addFirst(element);
            return;
        }
        this.size++;

        Node<T> current = getNode(index - 1);
        current.next = new Node<T>(element, current.next);
    }

    @Override
    public T getFirst() {
        return this.head.value;
    }

    @Override
    public T getLast() {
        Node<T> last = this.head;

        while (last.next != null)
            last = last.next;

        return last.value;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        return getNode(index).value;
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException {
        Node<T> node = getNode(index);
        T tmp = node.value;
        node.value = element;
        return tmp;
    }

    @Override
    public T removeFirst() throws IndexOutOfBoundsException {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        this.size--;

        Node<T> first = this.head;
        this.head = this.head.next;
        return first.value;
    }

    @Override
    public T removeLast() throws IndexOutOfBoundsException {
        return remove(this.size - 1);
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index == 0)
            return removeFirst();
        this.size--;

        Node<T> previous = getNode(index - 1);
        T removedElement = previous.next.value;
        previous.next = previous.next.next;
        return removedElement;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder().append("[");

        for (Node<T> current = this.head; current != null; current = current.next)
            string.append(current.value.toString()).append(", ");

        return (isEmpty() ? string.append("]") : string.replace(string.length() - 2, string.length(), "]")).toString();
    }
}
