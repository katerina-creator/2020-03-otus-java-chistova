package ru.otus.chistova;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class RunnerClass {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = TestClass.class;
        Constructor<TestClass> constructor = clazz.getConstructor(String.class);
        TestClass object = constructor.newInstance("name");

        //Получим все методы класса
        Method[] methods = clazz.getMethods();

        boolean hasAnnotationBefore = false;
        boolean hasAnnotationTest = false;
        boolean hasAnnotationAfter = false;

        List<Method> methodsBefore = new ArrayList<>();
        List<Method> methodsTest = new ArrayList<>();
        List<Method> methodsAfter = new ArrayList<>();

        //Перебираем все методы для определения их аннотаций
        for (int i = 0; i < methods.length; i++) {
            //Определим типы параметров i-го метода
            Class<?>[] parameterTypes = methods[i].getParameterTypes();
            try {
                hasAnnotationBefore = clazz.getDeclaredMethod(methods[i].getName(), parameterTypes).isAnnotationPresent(Before.class);
                hasAnnotationTest = clazz.getDeclaredMethod(methods[i].getName(), parameterTypes).isAnnotationPresent(Test.class);
                hasAnnotationAfter = clazz.getDeclaredMethod(methods[i].getName(), parameterTypes).isAnnotationPresent(After.class);

                //Проверяем аннотацию и помещаем метод в соответсвующий список
                if (hasAnnotationBefore) methodsBefore.add(methods[i]);
                else if (hasAnnotationTest) methodsTest.add(methods[i]);
                else if (hasAnnotationAfter) methodsAfter.add(methods[i]);
            } catch (NoSuchMethodException e) {

            }
        }
        //Перечисляем все методы и параметры тестируемого класса
        String[] parameterType1 = {"Вася"};
        Integer[] parameterType2 = {4, 2};
        Integer[] parameterType3 = null;

        //Выполняем все списки методов, согласно порядку
        for (int i = 0; i < methodsBefore.size(); i++) {
            try {
                var result = methodsBefore.get(i).invoke(object, (Object[]) parameterType1);
                System.out.println("result:" + result);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        for (int i = 0; i < methodsTest.size(); i++) {
            try {
                var result = methodsTest.get(i).invoke(object, (Object[]) parameterType2);
                System.out.println("result:" + result);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        for (int i = 0; i < methodsAfter.size(); i++) {
            try {
                var result = methodsAfter.get(i).invoke(object, (Object[]) parameterType3);
                System.out.println("result:" + result);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
