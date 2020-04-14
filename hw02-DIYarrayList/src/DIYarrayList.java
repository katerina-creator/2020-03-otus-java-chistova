import java.util.*;

public class DIYarrayList<T> implements List<T> {

    public static <T> boolean addAll(Collection<? super T> c, T... elements) {
        //Помещаем все элементы в типизированный массив mas
        T[] mas = elements;
        int count_mas = mas.length;

        //Добавляем все элементы в типизированную коллекцию
        for (int i=0; i< count_mas; i++) {
            c.add(mas[i]);
        }

        //Если элементы передались, то размер будет больше 0, возвращаем true
        if (c.size()>0) return true; else return false;
    }

    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        //Создаем типизированный переборщик, согласно типу копируемого списка src
        Iterator<? extends T> iterator = src.iterator();
        int i = 0;
        try {
            //По циклу бежим переборщиком и добавляем элементы в принимающий список
            while (i<src.size()) {
                dest.add(src.get(i));
                iterator.next();
                i++;
            }
        } catch (IndexOutOfBoundsException ex) {
            //Выводим ощибку, если в цикле произойдет выход за пределы
            ex.getMessage();
        }
    }

    public static <T> void sort(List<T> list, Comparator<? super T> c) {
        //Передали список в массив mas
        T[] mas = (T[]) list.toArray();
        //Отсортировали по компаратору массив mas
        Arrays.sort(mas, c);

        //Заводим итератор для списка из параметра
        ListIterator<T> listiterator = list.listIterator();
        //Заводим типизированный массив, помещая туда mas
        T[] mas_T = mas;
        int count_mas = mas.length;

        //Бежим по массиву и типизируем каждый элемент, передавая его в листитератор списка
        for(int i = 0; i < count_mas; ++i) {
            T e = (T) mas_T[i];
            listiterator.next();
            listiterator.set(e);
        }
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        return false;
    }

    @Override
    public void clear() {
        throw  new UnsupportedOperationException();
    }

    @Override
    public T get(int i) {
        return null;
    }

    @Override
    public Object set(int i, Object o) {
        return null;
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
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int i) {
        return null;
    }

    @Override
    public List subList(int i, int i1) {
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
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }
}
