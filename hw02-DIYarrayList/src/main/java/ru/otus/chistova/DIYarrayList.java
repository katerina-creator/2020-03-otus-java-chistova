package ru.otus.chistova;

import java.util.*;
import java.util.function.Consumer;

public class DIYarrayList<T> implements List<T> {
    private Object[] data;
    //длина занятой части массива
    private int size;
    private Iterator iterator;

    private class DIYiterator<T> implements Iterator {
        int cursor=0;
        int size;
        Object[] data;

        public DIYiterator(DIYarrayList<T> diYarrayList) {
            this.size = diYarrayList.size();
            this.data= diYarrayList.data;
        }

        @Override
        public boolean hasNext() {
            if (cursor < size) return true;
            return false;
        }

        @Override
        public T next() {
            if (cursor<size) {
                T elem =  (T) data[cursor];
                cursor++;
                return elem;
            }
            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        if (data.length==0) return true;
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        iterator = new DIYiterator(this);
        return iterator;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if (size == data.length) {
            Object[] newData = new Object[size*2];
            newData = Arrays.copyOf(data, size);
            data = newData;
        }
        data[size] = o;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        return this.addAll(this.size, collection);
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        if (collection.size()==0)  return false;
        else
            for (Object o:collection) {
                this.add(o);
            }
        return true;

    }

    @Override
    public void clear() {
        throw  new UnsupportedOperationException();
    }

    @Override
    public T get(int i) {
        return (T) data[i];
    }

    @Override
    public T set(int i, Object o) {
        return (T) (data[i]=o);
    }

    @Override
    public void add(int i, Object o) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public T remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        return null;
    }

    @Override
    public List<T> subList(int i, int i1) {
        return null;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public T[] toArray(Object[] objects) {
        return (T[])new Object[0];
    }
}
