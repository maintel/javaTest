package 代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AdminHandler implements InvocationHandler {

    private Object object;

    public AdminHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理：：======");
        method.invoke(object,args);
        System.out.println("动态代理：：======");
        return null;
    }
}
