package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        CountMap<Integer> countMap = new CountMapImpl<>();

        countMap.add(10);
        countMap.add(10);
        countMap.add(5);
        countMap.add(6);
        countMap.add(5);
        countMap.add(10);

        System.out.println(countMap.size()); // 3
        System.out.println(countMap.remove(7)); // 0
        System.out.println(countMap.toMap()); // {5=2, 6=1, 10=3}

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        countMap.toMap(hashMap);
        System.out.println(hashMap);

        System.out.println(countMap.getCount(5)); // 2
        System.out.println(countMap.getCount(6)); // 1
        System.out.println(countMap.getCount(10)); // 3

        System.out.println(countMap.remove(10)); // 3
        System.out.println(countMap.toMap()); // {5=2, 6=1}
        countMap.addAll(countMap);
        System.out.println(countMap.toMap()); // {5=4, 6=2}

        CountMap<Integer> countMap2 = new CountMapImpl<>();
        CountMap<Integer> countMap3 = new CountMapImpl<>();
        countMap2.addAll(countMap);
        countMap.toMap(countMap3.toMap());
        System.out.println(countMap2.toMap()); // {5=4, 6=2}
        System.out.println(countMap3.toMap()); // {5=4, 6=2}
    }

}