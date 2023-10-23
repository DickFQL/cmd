package dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CreateCglib implements MethodInterceptor {
    private Object object;

    public CreateCglib(Object object) {
        this.object = object;
    }

    public Object getProxy(){
//        创建一个cglib对象
        Enhancer enhancer= new Enhancer();

//        设置父类对象
        enhancer.setSuperclass(object.getClass());
//        设置一个增强的接口
        enhancer.setCallback(this);
//        构建代理对象
        Object obj = enhancer.create();
        return obj;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置通知");
        Object invoke = method.invoke(object, objects);
        System.out.println("后置通知");
        return invoke;
    }
}
