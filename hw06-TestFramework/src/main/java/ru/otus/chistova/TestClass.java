package ru.otus.chistova;

import ru.otus.chistova.After;
import ru.otus.chistova.Before;
import ru.otus.chistova.Test;

public class TestClass {

    private String name;

    public TestClass(String name) {
        this.name = name;
    }

    @Before
    public void setName(String name) {
        this.name= name;
    }

    @Test
    public int divideInt(int a, int b) {
        return a/b;
    }

    @After
    public String sayBye() {
        return ("Bye-bye, "+ this.name);
    }
}
