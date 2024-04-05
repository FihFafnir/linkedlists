package br.edu.ifpb.eda.circularsimple;

import br.edu.ifpb.eda.interfaces.ILinkedList;

public class LinkedList<T> implements ILinkedList<T> {
    private Node<T> root;
    private int size;

    public LinkedList() {
        this.root = new Node<T>();
        this.size = 0;
    }

    private Node<T> getNode(int index) throws IndexOutOfBoundsException {
        Node<T> current = this.root.next;

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        for (int count = 0; count < index; count++)
            current = current.next;

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
        this.root.next = this.root;
        this.size = 0;
    }

    @Override
    public void addFirst(T element) {
        this.size++;
        this.root.next = new Node<T>(element, this.root.next);
    }

    @Override
    public void addLast(T element) {
        add(size, element);
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
        return this.root.next.value;
    }

    @Override
    public T getLast() {
        return get(size - 1);
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

    private T removeNextNode(Node<T> previous) throws IndexOutOfBoundsException {
        if (isEmpty())
            throw new IndexOutOfBoundsException();

        this.size--;
        T tmp = previous.next.value;
        previous.next = previous.next.next;
        return tmp;
    }

    @Override
    public T removeFirst() throws IndexOutOfBoundsException {
        return removeNextNode(this.root);
    }

    @Override
    public T removeLast() throws IndexOutOfBoundsException {
        return remove(size - 1);
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        return index == 0 ? removeFirst() : removeNextNode(getNode(index - 1));
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder().append("[");

        for (Node<T> current = this.root.next; current != this.root; current = current.next)
            string.append(current.value.toString()).append(", ");

        return (isEmpty() ? string.append("]") : string.replace(string.length() - 2, string.length(), "]")).toString();
    }
}
