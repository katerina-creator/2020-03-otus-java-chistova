package test;

import ru.otus.chistova.annotation.After;
import ru.otus.chistova.annotation.Before;
import ru.otus.chistova.annotation.Test;
import java.lang.reflect.Method;
import java.util.*;

public class RunnerClass {
    private static Class clazz;
    private static BotClassTest object =null;
    private static int testsCount = 0, testsPassed = 0;
    private static final String USERNAME = "Вася";
    private static List<Method> methodsBefore, methodsTest, methodsAfter;

    public static void main(String[] args)  {
        clazz = BotClassTest.class;
        //Запускаем runner тестов
        runTests();
    }

    public static void runTests() {
        Method[] methods = clazz.getMethods();
        //Списки методов для последовательного запуска
        methodsBefore = new ArrayList<>();
        methodsTest = new ArrayList<>();
        methodsAfter = new ArrayList<>();

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
        executeMethods();

        System.out.println("Run tests: "+testsCount);
        System.out.println("Correct tests: "+testsPassed);
        System.out.println("Failed tests: "+(testsCount-testsPassed));

    }

    //Выполнение списков методов
    public static void executeMethods() {


        //Выполняем все списки методов Test
        for (int i = 0; i < methodsTest.size(); i++) {
            testsCount++;
            try {
                object = new BotClassTest(USERNAME);
                //Выполняем все тесты @Before
                for (int j = 0; j < methodsBefore.size(); j++) {
                    methodsBefore.get(j).invoke(object);
               }

                methodsTest.get(i).invoke(object);
                testsPassed++;
                //Выполняем все тесты @After
                for (int j = 0; j < methodsAfter.size(); j++) {
                    methodsAfter.get(j).invoke(object);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }


}
