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

    public static <T> boolean addAll(Collection<? super T> c, T... elements) {
        DIYarrayList<? super T> diy_list = new DIYarrayList<>();
        T[] elem = elements;
        int count_elem = elem.length;

        diy_list.data = new Object[count_elem];

        int i=0;
        while (i<count_elem) {
            diy_list.add(elem[i]);
            i++;
        }

        for (Object t:diy_list.data) {
            c.add((T) t);
        }

        if (c.size()>0) {
            return true; }else return false;
    }

    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        DIYarrayList<? extends T> src_list = new DIYarrayList<>();
        src_list.data = new Object[src.size()];

        int i=0;
        while (i<src.size()) {
            src_list.add(src.get(i));
            i++;
        }

        Iterator src_itr = src_list.iterator();

        i=0;
        try {
            while (src_itr.hasNext()) {
                dest.set(i,src.get(i));
                i++;
            }
        } catch (IndexOutOfBoundsException ex) {
            ex.getMessage();
        }
    }


    public static <T> void q_Sort (DIYarrayList<T> diy_arr, int first, int last, Comparator<? super T> c ) {
        int middle = first + (last - first) / 2;

        T elem = (T) diy_arr.data[middle];

        int i = first, j = last;

        while (i <= j) {
            while (c.compare((T) diy_arr.data[i], elem)<0) {
                i++;
            }
            while (c.compare((T) diy_arr.data[j], elem)>0) {
                j--;
            }
            if (i <= j) {
                T temp = (T) diy_arr.data[i];
                diy_arr.data[i] = diy_arr.data[j];
                diy_arr.data[j] = temp;
                i++;
                j--;
            }
        }
        if (first < j) q_Sort(diy_arr, first, j, c);
        if (last > i) q_Sort(diy_arr, i, last, c);

    }

    public static <T> void sort(List<T> list, Comparator<? super T> c) {
        DIYarrayList<T> diy_list = new DIYarrayList<>();
        diy_list.data = new Object[list.size()];
        diy_list.addAll(list);

        if (!diy_list.isEmpty()) {
            q_Sort(diy_list, 0, diy_list.size-1, c);
        } else return;


        for (int i=0; i<diy_list.size(); i++) {
            list.set(i,diy_list.get(i));
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
