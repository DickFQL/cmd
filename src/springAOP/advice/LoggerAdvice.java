package springAOP.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggerAdvice {

    public void beforeAdvice(){
        System.out.println("前置通知开始记录日志");
    }

    public void afterAdvice(){
        System.out.println("后置通知开始记录日志");
    }
    public void exceptionAdvice(){
        System.out.println("异常通知开始记录日志");
    }
    public void finallyAdvice(){
        System.out.println("最终通知开始记录日志");
    }
//    环绕通知
//    获取目标方法的参数
    public void aroundAdvice(ProceedingJoinPoint point){
        try {

            System.out.println("前置通知");
//            获取目标方法的参数
            Object[] args = point.getArgs();
//        调用目标方法
            Object proceed = point.proceed(args);
            System.out.println("这是参数"+args[0]);
            System.out.println("后置通知");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }


    }
}
