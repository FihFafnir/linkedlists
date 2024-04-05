package br.edu.ifpb.eda;

import br.edu.ifpb.eda.circulardoublyordered.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.add(8);
        ll.add(22);
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        System.out.println(ll.toString());
        ll.remove(0);
        System.out.println(ll.toString());
    }
}
