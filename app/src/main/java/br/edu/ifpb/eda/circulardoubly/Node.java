package br.edu.ifpb.eda.circulardoubly;

public class Node<T> {
    protected T value;
    protected Node<T> next;
    protected Node<T> previous;

    protected Node() {
        this.value = null;
        this.previous = this;
        this.next = this;
    }

    protected Node(T value) {
        this.value = value;
        this.previous = this;
        this.next = this;
    }

    protected Node(T value, Node<T> previous, Node<T> next) {
        this.value = value;
        this.previous = previous;
        this.next = next;

        this.previous.next = this.next.previous = this;
    }
}
