package dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *代理类  增强目标类
 */
public class CreateProxy {

    private Object object;

    public CreateProxy(Object object) {
        this.object = object;
    }
    public Object getObject(){

        /**
         * ClassLoader loader 目标类的加载器 固定写法
         * Class[] interfaces 目标对象实现的接口 固定写法
         * InvocationHandler 是一个增强目标方法的接口
         *
         */
        Object obj = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            /**
             *
             * @param proxy the proxy instance that the method was invoked on
             *基本用不到 是目标对象
             *
             * @param method the {@code Method} instance corresponding to
             * the interface method invoked on the proxy instance.  The declaring
             * class of the {@code Method} object will be the interface that
             * the method was declared in, which may be a superinterface of the
             * proxy interface that the proxy class inherits the method through.
             *Method 目标对象的方法字节码对象
             *
             *
             *
             * @param args an array of objects containing the values of the
             * arguments passed in the method invocation on the proxy instance,
             * or {@code null} if interface method takes no arguments.
             * Arguments of primitive types are wrapped in instances of the
             * appropriate primitive wrapper class, such as
             * {@code java.lang.Integer} or {@code java.lang.Boolean}.
             *
             *
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });

        return null;
    }
}
