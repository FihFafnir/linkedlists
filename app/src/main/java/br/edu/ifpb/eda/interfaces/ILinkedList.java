package br.edu.ifpb.eda.interfaces;

public interface ILinkedList<T> {
    public boolean isEmpty();

    public int size();

    public void clear();

    public void addFirst(T element);

    public void addLast(T element);

    public void add(int index, T element) throws IndexOutOfBoundsException;

    public T getFirst();

    public T getLast();

    public T get(int index) throws IndexOutOfBoundsException;

    public T set(int index, T element) throws IndexOutOfBoundsException;

    public T removeFirst() throws IndexOutOfBoundsException;

    public T removeLast() throws IndexOutOfBoundsException;

    public T remove(int index) throws IndexOutOfBoundsException;
}
