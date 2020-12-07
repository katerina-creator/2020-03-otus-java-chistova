package proxy;

public class DemoAutoLog {
    public static void main(String[] args) {
        AutoLogInterface myClass = Ioc.createClass();
        myClass.calculation(7, 6, "Тест");
    }
}
