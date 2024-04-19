package br.edu.ifpb.eda;

import br.edu.ifpb.eda.doubly.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedList<Integer>();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.addLast(9);
        ll.addLast(10);
        System.out.println(ll.toString());
        System.out.println(ll.get(0));
        System.out.println(ll.get(9));
        // ll.remove(0);
        // ll.remove(9);
        System.out.println(ll.toString());
    }
}
