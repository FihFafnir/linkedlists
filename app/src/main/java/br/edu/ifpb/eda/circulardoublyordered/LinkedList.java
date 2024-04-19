package br.edu.ifpb.eda.circulardoublyordered;

public class LinkedList<T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    public LinkedList() {
        this.root = new Node<T>();
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

    private Node<T> getNode(int index, int beginIndex) {
        return getNode(index, beginIndex, beginIndex < index ? root.next : root.previous);
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size)
            return null;
        return getNode(index, index < (size >> 1) ? 0 : size);
    }

    public boolean isEmpty() {
        return this.root.next == this.root;
    }

    public int size() {
        return size;
    }

    public void clear() {
        this.root.previous = this.root.next = this.root;
        this.size = 0;
    }

    public void add(T element) {
        this.size++;
        Node<T> current = this.root.next;

        while (current.value != null && current.value.compareTo(element) == -1)
            current = current.next;

        new Node<T>(element, current.previous, current);
    }

    public T get(int index) {
        return getNode(index).value;
    }

    private boolean remove(Node<T> node) {
        if (isEmpty() || node == null)
            return false;
        this.size--;

        node.previous.next = node.next;
        node.next.previous = node.previous;
        return true;
    }

    public boolean remove(int index) {
        return remove(getNode(index));
    }

    public boolean remove() {
        return remove(this.root.next);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder().append("[");

        for (Node<T> current = this.root.next; current != this.root; current = current.next)
            string.append(current.value.toString()).append(", ");

        return (isEmpty() ? string.append("]") : string.replace(string.length() - 2, string.length(), "]")).toString();
    }

    public void adicionar(T elemento) {
        add(elemento);
    }

    public boolean remover(int index) {
        return remove(index);
    }

    public boolean remover() {
        return remove();
    }

    public Node<T> getNodo(int index) {
        return getNode(index);
    }

    public int tamanho() {
        return size();
    }
}
