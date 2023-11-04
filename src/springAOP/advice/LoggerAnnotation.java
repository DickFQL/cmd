package springAOP.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 通知类
 * @Aspect 声明在当前通知类中配置切面
 */
@Aspect
@Component
public class LoggerAnnotation {

    @Pointcut("execution(* springAOP.service.ModuleService.*(..))")
    public void pt01(){

    }
    @Before("pt01()")
    public void beforeAdvice(){
        System.out.println("前置通知开始记录日志");
    }
    @After("pt01()")
    public void afterAdvice(){
        System.out.println("后置通知开始记录日志");
    }
    @AfterThrowing("pt01()")
    public void exceptionAdvice(){
        System.out.println("异常通知开始记录日志");
    }
    @AfterReturning("pt01()")
    public void finallyAdvice(){
        System.out.println("最终通知开始记录日志");
    }


}
