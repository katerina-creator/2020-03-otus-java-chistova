package proxy;

import java.lang.reflect.Method;
import java.util.List;

public class DemoAutoLog {

    public static void main(String[] args) {
        AutoLogInterface myClass = Ioc.createClass();
        myClass.calculation(7, 6, "Тест");
        myClass.calculation();
    }

}
