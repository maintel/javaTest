package 代理;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        IManager manager = new AdminProxy();
        manager.doSome();
        IManager manager2 = new AdminDecorator(admin);
        manager2.doSome();

        AdminHandler adminHandler = new AdminHandler(admin);
        Class<?> cls = admin.getClass();
        IManager m = (IManager) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), adminHandler);
        m.doSome();
    }
}