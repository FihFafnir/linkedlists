package br.edu.ifpb.eda.circulardoubly;

import br.edu.ifpb.eda.interfaces.ILinkedList;

public class LinkedList<T> implements ILinkedList<T> {
    private Node<T> root;
    private int size;

    public LinkedList() {
        this.root = new Node<T>();
        this.size = 0;
    }

    private Node<T> getNode(int index) throws IndexOutOfBoundsException {
        Node<T> current;

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (index < (size >> 1)) {
            current = this.root.next;
            for (int count = 0; count < index; count++)
                current = current.next;
        } else {
            current = this.root.previous;
            for (int count = size; count > index; count--)
                current = current.previous;
        }

        return current;
    }

    @Override
    public boolean isEmpty() {
        return this.root.next == this.root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        this.root.previous = this.root.next = this.root;
        this.size = 0;
    }

    @Override
    public void addFirst(T element) {
        this.size++;
        new Node<T>(element, this.root, this.root.next);
    }

    @Override
    public void addLast(T element) {
        this.size++;
        new Node<T>(element, this.root.previous, this.root);
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException {
        this.size++;
        Node<T> current = getNode(index);
        new Node<T>(element, current.previous, current.next);
    }

    @Override
    public T getFirst() {
        return this.root.next.value;
    }

    @Override
    public T getLast() {
        return this.root.previous.value;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        return getNode(index).value;
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException {
        Node<T> current = getNode(index);
        T tmp = current.value;
        current.value = element;
        return tmp;
    }

    private T remove(Node<T> node) throws IndexOutOfBoundsException {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        this.size--;

        node.previous.next = node.next;
        node.next.previous = node.previous;
        return node.value;
    }

    @Override
    public T removeFirst() throws IndexOutOfBoundsException {
        return remove(this.root.next);
    }

    @Override
    public T removeLast() throws IndexOutOfBoundsException {
        return remove(this.root.previous);
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        return remove(getNode(index));
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder().append("[");

        for (Node<T> current = this.root.next; current != this.root; current = current.next)
            string.append(current.value.toString()).append(", ");

        return (isEmpty() ? string.append("]") : string.replace(string.length() - 2, string.length(), "]")).toString();
    }
}
