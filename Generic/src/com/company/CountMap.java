package com.company;

import java.util.List;
import java.util.Map;

public interface CountMap<K> {
    void add(K k);

    int getCount(K k);

    //current count
    int remove(K k);

    int size();

    void addAll(CountMap<K> source);

    Map<K, Integer> toMap();

    void toMap(Map<K, Integer> destination);
}