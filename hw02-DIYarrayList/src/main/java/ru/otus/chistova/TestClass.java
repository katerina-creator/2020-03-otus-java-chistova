package ru.otus.chistova;

import java.util.*;

public class TestClass {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList();
        list1.add(5);
        Collections.addAll(list1,
				21, 22, 23, 24, 25,
                26, 27, 28, 29, 30, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                1, 2,3, 4, 5, 6, 7, 8, 9,10);
        System.out.println("Вывод добавленного: ");
        for (int b = 0; b< list1.size(); b++) {
            System.out.print(list1.get(b)+" ");


        }
        System.out.println();

        List list2 = new ArrayList();
        Collections.addAll(list2,
    			221, 222, 223, 224, 225,
                226, 227, 228, 229, 230, 211, 212, 213, 214, 215, 216, 217, 228, 219, 220,
                22, 222,23, 24, 25, 26, 27, 28, 29,210, 222, 2222, 22222, 2);

        Collections.copy(list2, list1);

        System.out.println("Вывод скопированного: ");
        for (int b = 0; b< list2.size(); b++) {
            System.out.print(list2.get(b)+" ");


        }
        System.out.println();

        Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }};

        Collections.sort(list2,comparator);

        System.out.println("Вывод отсортированного: ");
        for (int b = 0; b< list2.size(); b++) {
            System.out.print(list2.get(b)+" ");

        }
    }
}
