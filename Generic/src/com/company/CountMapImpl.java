package com.company;

import java.util.*;

public class CountMapImpl<K> implements CountMap<K> {

    private HashMap<K, Integer> map = new HashMap<>();

    @Override
    public void add(K k) {
        if (map.containsKey(k))
            map.put(k, map.get(k) + 1);
        else
            map.put(k, 1);
    }

    @Override
    public int getCount(K k) {
        if (!map.containsKey(k))
            return 0;

        return map.get(k);
    }

    @Override
    public int remove(K k) {
        if (!map.containsKey(k))
            return 0;

        return map.remove(k);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<K> source) {
        for (K key : source.toMap().keySet())
            if (map.containsKey(key))
                map.put(key, map.get(key) + source.toMap().get(key));
            else
                map.put(key, source.toMap().get(key));
    }

    @Override
    public Map<K, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<K, Integer> destination) {
        destination.putAll(map);
    }
}
