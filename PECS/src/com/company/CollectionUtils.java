package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? super T> source, T o) {
        for (int i = 0; i < source.size(); i++)
            if (source.get(i).equals(o))
                return i;

        return -1;
    }

    public static <T> List<T> limit(List<T> source, int size) {
        return source.subList(0, size);
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for (T t : c2)
            if (c1.contains(t))
                return true;

        return false;
    }

    public static <T extends Comparable<? super T>, V extends T> List<V> range(List<V> list, T min, T max) {
        List<V> result = newArrayList();

        for (V v : list) {
            if (v.compareTo(min) >= 0 && v.compareTo(max) <= 0)
                result.add(v);
        }

        return result;
    }

    public static <T, V extends T> List<V> range(List<V> list, T min, T max, Comparator<? super T> comparator) {
        List<V> result = newArrayList();

        for (V v : list)
            if (comparator.compare(v, min) >= 0 && comparator.compare(v, max) <= 0)
                result.add(v);

        return result;
    }
}