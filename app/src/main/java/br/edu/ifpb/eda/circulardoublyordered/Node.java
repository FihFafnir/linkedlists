package br.edu.ifpb.eda.circulardoublyordered;

public class Node {
    protected Integer value;
    protected Node next;
    protected Node previous;

    protected Node() {
        this.value = null;
        this.previous = this;
        this.next = this;
    }

    protected Node(Integer value) {
        this.value = value;
        this.previous = this;
        this.next = this;
    }

    protected Node(Integer value, Node previous, Node next) {
        this.value = value;
        this.previous = previous;
        this.next = next;

        this.previous.next = this.next.previous = this;
    }
}
