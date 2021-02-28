package org.example.ch2;

public class NodeDemo {
    public static void main(String[] args) {
        NodeList<String> ns = new NodeList<>();
        ns.insertAtLast("a");
        ns.insertAtLast("b");
        ns.insertAtLast("c");
        Node<String> b = ns.locate("c");
        ns.insert("b2", b);
        System.out.println(ns.getSize());
        System.out.println(ns.getData(4));

        ns.deleteAt(4);
        System.out.println(ns.getSize());

        NodeList<Integer> ns2 = new NodeList<>(1,2,3,4,5);
        System.out.println(ns2.getData(1));

        NodeList<Integer> ns3 = new NodeList<>(1,3,5,7,9);

       NodeList<Integer> ns5 = ns2.merge(ns3);

       System.out.println(ns5.getSize());
    }
}
