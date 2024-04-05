package br.edu.ifpb.eda.circulardoublyordered;

public class LinkedList {
    private Node root;
    private int size;

    public LinkedList() {
        this.root = new Node();
        this.size = 0;
    }

    private Node getNode(int index) {
        Node current;

        if (index < 0 || index >= size)
            return null;

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

    public void add(Integer element) {
        this.size++;
        Node current = this.root.next;

        while (current.value != null && current.value < element)
            current = current.next;

        new Node(element, current.previous, current);
    }

    public Integer get(int index) {
        return getNode(index).value;
    }

    private boolean remove(Node node) {
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

    public String toString() {
        StringBuilder string = new StringBuilder().append("[");

        for (Node current = this.root.next; current != this.root; current = current.next)
            string.append(current.value.toString()).append(", ");

        return (isEmpty() ? string.append("]") : string.replace(string.length() - 2, string.length(), "]")).toString();
    }
}
