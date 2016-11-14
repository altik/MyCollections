package com.funky_line.mycollections.myinterface;

/**
 * Created by Rudniev Oleksandr on 10.11.2016.
 */
public interface Ilist<T> {

    boolean add(T t);

    boolean add(int i, Object value);

    boolean remove(int index);

    boolean contains(T t);

    Object get(int position);

    int size();

    boolean isEmpty();

    void clear();

    boolean set(int o, Object value);
}