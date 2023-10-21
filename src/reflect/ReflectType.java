package reflect;

import java.lang.reflect.InvocationTargetException;

public class ReflectType {
    public String myMethod() {
        return "123";
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        System.out.println(Class.forName("reflect.ReflectType").getMethod("myMethod").getReturnType());
        System.out.println(Class.forName("java.net.URL").getMethod("hashCode").getReturnType());
    }
}
