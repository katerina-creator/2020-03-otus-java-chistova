package test;

import org.junit.jupiter.api.DisplayName;
import ru.otus.chistova.BotClass;
import ru.otus.chistova.annotation.After;
import ru.otus.chistova.annotation.Before;
import ru.otus.chistova.annotation.Test;

public class BotClassTest {

    private BotClass botClass;
    private String value = "initValue";

    public BotClassTest(String value) {

        this.value = value;
        setUp();
    }


    @Before
    public void setUp() {
        botClass = new BotClass();
    }

    @Test
    public void whenNameIsNullShouldThrowIllegalArgumentException() {
        botClass.seyHello(null);
    }

    @Test
    public void whenNameIsNotNullShouldSayHello() {
        botClass.seyHello("Вася");
    }

    @Test
    public void whenDivideIntIsIncorrectShouldThrowArithmeticException() {
        botClass.divideInt(1,0);
    }

    @Test
    public void whenDivideIntIsСorrectShouldDivide() {
        botClass.divideInt(6,3);
    }

    @After
    public void whenSayBye() {
        botClass.sayBye();
    }
}
