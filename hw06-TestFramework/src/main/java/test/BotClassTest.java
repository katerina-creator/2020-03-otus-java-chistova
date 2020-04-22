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
    }

    @Before
    public void setUp() {
        botClass = new BotClass();
    }

    @DisplayName("вывести исключение при попытке задать имя null")
    @Test
    public void whenNameIsNullShouldThrowIllegalArgumentException() {
        botClass.seyHello(null);
    }

    @DisplayName("поздороваться при передаче корректного имени")
    @Test
    public void whenNameIsNotNullShouldSayHello() {
        botClass.seyHello("Вася");
    }

    @DisplayName("вывести ошибку при делении на ноль")
    @Test
    public void whenDivideIntIsIncorrectShouldThrowArithmeticException() {
        botClass.divideInt(1,0);
    }

    @DisplayName("произвести вычисление")
    @Test
    public void whenDivideIntIsСorrectShouldDivide() {
        botClass.divideInt(6,3);
    }

    @DisplayName("попрощаться с пользователем")
    @After
    public void whenSayBye() {
        botClass.sayBye();
    }
}
