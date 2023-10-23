package dynamicproxy.cglib;

public class TestCglib {
    public static void main(String[] args) {
//
        CglibProxyImpl cglibProxy = new CglibProxyImpl();
//
        Object proxy = new CreateCglib(cglibProxy).getProxy();
//        强转
        CglibProxyImpl proxy1 = (CglibProxyImpl) proxy;

        proxy1.proxy();

    }
}
