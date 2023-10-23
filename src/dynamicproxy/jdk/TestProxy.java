package dynamicproxy.jdk;

import java.lang.reflect.InvocationTargetException;

public class TestProxy {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CreateProxy createProxy = new CreateProxy(new ProxyImpl());
        Object proxy = createProxy.getProxy();
        ProxyInterface proxy1 = (ProxyInterface) proxy;
//        反射
//        proxy.getClass().getDeclaredMethod("eat", String.class).invoke(proxy,"苹果");
        proxy1.eat("苹果");


    }
}
