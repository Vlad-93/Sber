package com.company;

public class Main {

    public static void main(String[] args) {
        Person p1 = new Person(true, "Vlad");
        Person p2 = new Person(false, "Vika");

        // marry Vlad and Vika
        p1.marry(p2);

        Person p3 = new Person(true, "Vasya");
        Person p4 = new Person(false, "Anna");

        // marry Vasya and Anna
        p3.marry(p4);

        // marry each other:
        p1.marry(p3);   // false
        p1.marry(p4);   // true

        System.out.println(p1.getName() + ((p1.getSpouse() == null) ? " not married" : " married to " + p1.getSpouse().getName()));
        System.out.println(p2.getName() + ((p2.getSpouse() == null) ? " not married" : " married to " + p2.getSpouse().getName()));
        System.out.println(p3.getName() + ((p3.getSpouse() == null) ? " not married" : " married to " + p3.getSpouse().getName()));
        System.out.println(p4.getName() + ((p4.getSpouse() == null) ? " not married" : " married to " + p4.getSpouse().getName()));
    }
}
