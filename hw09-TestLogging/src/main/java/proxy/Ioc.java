package proxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;


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

        public void printAutoLog(Method method, Object[] args) {
            System.out.print("executed method: " + method.getName() + ", param: ");
            for (int i = 0; i < args.length; i++) {
                if (args == null) System.out.println(" ");
                if (i == args.length - 1) System.out.println(args[i]);
                else System.out.print(args[i] + ", ");
            }
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Annotation annotation = method.getAnnotation(Log.class);
            if (annotation!=null) {
                printAutoLog(method,args);
            }
                return method.invoke(myClass, args);
        }
    }

}

