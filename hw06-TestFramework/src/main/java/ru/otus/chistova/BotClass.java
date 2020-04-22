package ru.otus.chistova;

import ru.otus.chistova.annotation.After;
import ru.otus.chistova.annotation.Before;
import ru.otus.chistova.annotation.Test;

public class BotClass {

    private String name;

    public BotClass() {
    }

    public String seyHello(String name) throws IllegalArgumentException {
        if (name==null) throw new IllegalArgumentException("The name cannot be empty!");

        this.name = name;
        return ("Hello, "+ this.name);
    }

    public int divideInt(int a, int b) throws ArithmeticException
    {
        if (b==0) throw new ArithmeticException("You can't divide by zero!");

        return a/b;
    }

    public String sayBye() {
        return ("Bye-bye!");
    }
}
