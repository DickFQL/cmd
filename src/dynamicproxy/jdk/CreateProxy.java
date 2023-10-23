package dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *创建代理类的类
 */
public class CreateProxy {

    private Object object;

    public CreateProxy(Object object) {
        this.object = object;
    }
    public Object getProxy(){

        /**
         * ClassLoader loader 目标类的加载器 固定写法object.getClass(),getClassLoader()
         * Class[] interfaces 目标对象实现的接口 固定写法object.getClass(),getInterfaces()
         * InvocationHandler 是一个增强目标方法的接口
         *
         */
        Object obj = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            /**
             *
             * @param proxy the proxy instance that the method was invoked on
             *基本用不到 是目标对象
             *
             * @param method
             *Method 代理对象的方法字节码对象
             *
             *
             *
             * @param args an array of objects containing the values of the
             * 调用目标方法需要的参数
             *
             *
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("前置通知");
//              通过反射调用目标方法
                Object invoke = method.invoke(object, args);
                System.out.println("后置通知");
                return invoke;
            }
        });

        return obj;
    }
}
