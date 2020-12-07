package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class Ioc {
    private Ioc(){}

    static AutoLogInterface createClass(){
        AutoLog autoLog = new AutoLog();
        InvocationHandler handler = new MyInvocationHandler(autoLog);
        AutoLogInterface userProxy = (AutoLogInterface) Proxy.newProxyInstance(autoLog.getClass().getClassLoader(), AutoLog.class.getInterfaces(), handler);
        return userProxy;
    }

    static class MyInvocationHandler implements InvocationHandler {
        private final AutoLog myClass;

        MyInvocationHandler(AutoLog myClass) {
            this.myClass = myClass;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.print("executed method: "+method.getName()+", param: ");
            for (int i=0; i<args.length; i++){
                if (i==args.length-1) System.out.println(args[i]);
                else System.out.print(args[i]+", ");
            }
            return method.invoke(myClass, args);
        }

    }
}
