package br.edu.ifpb.eda;

import br.edu.ifpb.eda.circulardoublyordered.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedList<Integer>();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.add(8);
        ll.add(9);
        ll.add(10);
        System.out.println(ll.toString());
        // System.out.println(ll.get(1));
        // System.out.println(ll.get(8));
        // ll.remove(0);
        // ll.remove(9);
        System.out.println(ll.toString());
    }
}
