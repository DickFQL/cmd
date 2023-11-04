package springAOP.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import springAOP.service.ModuleService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class CreateProxy implements InvocationHandler{

    @Autowired
    @Qualifier("moduleServiceImpl")
    public ModuleService moduleService;

    public Object getProxy(){

        return Proxy.newProxyInstance(moduleService.getClass().getClassLoader(),moduleService.getClass().getInterfaces(), this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        Object invoke = null;

        try {
            System.out.println("前置通知开始记录日志");

            invoke = method.invoke(moduleService,args);

            System.out.println("后置通知开始记录日志");
        }catch (Exception e){
            System.out.println("异常通知");
            e.printStackTrace();
        }finally {
            System.out.println("最终通知");
        }

        return invoke;
    }

}
