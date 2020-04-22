package test;

import ru.otus.chistova.annotation.After;
import ru.otus.chistova.annotation.Before;
import ru.otus.chistova.annotation.Test;
import test.BotClassTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class RunnerClass {
    private static Class clazz;
    private static Constructor<BotClassTest> constructor = null;
    private static BotClassTest object =null;
    private static int testsCount = 0, testsPassed = 0;

    public static void main(String[] args)  {
        clazz = BotClassTest.class;
        try {
            constructor = clazz.getConstructor(String.class);
            object = constructor.newInstance("name");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //Запускаем runner тестов
        runTests();
    }

    public static void runTests() {
        Method[] methods = clazz.getMethods();
        //Списки методов для последовательного запуска
        List<Method> methodsBefore = new ArrayList<>();
        List<Method> methodsTest = new ArrayList<>();
        List<Method> methodsAfter = new ArrayList<>();

        //Перебираем все методы для определения их аннотаций и формирования списков методов
        for (int i = 0; i < methods.length; i++) {
            try {
                if (clazz.getDeclaredMethod(methods[i].getName()).isAnnotationPresent(Before.class))
                    methodsBefore.add(methods[i]);
                else if (clazz.getDeclaredMethod(methods[i].getName()).isAnnotationPresent(Test.class))
                    methodsTest.add(methods[i]);
                else if (clazz.getDeclaredMethod(methods[i].getName()).isAnnotationPresent(After.class))
                    methodsAfter.add(methods[i]);

            } catch (NoSuchMethodException e) {
               }
        }
        //Запуск списков методов
        executeMethods((ArrayList<Method>) methodsBefore);
        executeMethods((ArrayList<Method>) methodsTest);
        executeMethods((ArrayList<Method>) methodsAfter);

        System.out.println("Run tests: "+testsCount);
        System.out.println("Correct tests: "+testsPassed);
        System.out.println("Failed tests: "+(testsCount-testsPassed));

    }

    public static void executeMethods(ArrayList<Method> list) {
        //Выполняем все списки методов, согласно порядку
        for (int i = 0; i < list.size(); i++) {
            testsCount++;
            try {
                list.get(i).invoke(object);
                testsPassed++;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }


}
