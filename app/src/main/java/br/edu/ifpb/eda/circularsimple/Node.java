package br.edu.ifpb.eda.circularsimple;

public class Node<T> {
    protected T value;
    protected Node<T> next;

    protected Node() {
        this.value = null;
        this.next = this;
    }

    protected Node(T value) {
        this.value = value;
        this.next = this;
    }

    protected Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}
