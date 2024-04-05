package br.edu.ifpb.eda.doubly;

public class Node<T> {
    public T value;
    public Node<T> next;
    public Node<T> previous;

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public Node(T value, Node<T> previous, Node<T> next) {
        this.value = value;
        this.previous = previous;
        this.next = next;

        if (this.previous != null)
            this.previous.next = this;
        if (this.next != null)
            this.next.previous = this;
    }
}
