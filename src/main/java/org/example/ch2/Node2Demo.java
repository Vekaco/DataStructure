package org.example.ch2;

public class Node2Demo {
    public static void main(String[] args) {
        CircularNodeList<String> cnl = new CircularNodeList<>();
        cnl.insert("a", 1);
        System.out.println(cnl.find(1));
        System.out.println(cnl.delete(1));
        System.out.println(cnl.getSize());
    }
}
