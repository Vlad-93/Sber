package com.company;

import java.util.Iterator;
import java.util.List;

public class MyIterator <T> implements Iterator<T> {

    private int index;
    private List<T> list;

    public MyIterator(List<T> list) {
        index = list.size();
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index > 0;
    }

    @Override
    public T next() {
        return list.get(--index);
    }
}
