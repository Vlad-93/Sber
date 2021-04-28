package com.company;

import java.util.List;

import static com.company.CollectionUtils.*;

public class Main {

    public static void main(String[] args) {
        List<String> strings = newArrayList();
        strings.add("Vlad");
        List<Object> objects = newArrayList();
        objects.add(new Object());

        addAll(strings, objects);

        int index = indexOf(objects, "Vlad");
        System.out.println("index = " + index);

        objects = limit(objects, 1);
        objects.add("Vlad");
        removeAll(objects, strings);

        System.out.println(containsAll(objects, strings));
        addAll(strings, objects);

        System.out.println(containsAll(objects, strings));
        System.out.println(containsAny(objects, strings));

        System.out.println(range(strings, "A", "z"));
        System.out.println(range(strings, "A", "z", String::compareTo));
    }
}
