package reversecompile.main;

import java.lang.reflect.*;

public class ReflectUtils {
    private ReflectUtils(){}
    public static String reflectToString(String className){
//        创建字符串对象
        StringBuffer stringBuffer = new StringBuffer();

        try {
            Class<?> aClass = Class.forName(className);
            stringBuffer.append("public class ");
            stringBuffer.append(aClass.getSimpleName());
            stringBuffer.append("{"+"\n\n\t");
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                String Modistring = Modifier.toString(declaredField.getModifiers());
                String simpleName = declaredField.getType().getSimpleName();
                String fieldName = declaredField.getName();
                stringBuffer.append(Modistring+" "+simpleName+" "+fieldName+";"+"\n\n\t");
            }
//            构造 修饰+方法名（
            Constructor<?>[] declaredConstructor = aClass.getDeclaredConstructors();
            for (Constructor<?> constructor : declaredConstructor) {
                String constructString = Modifier.toString(constructor.getModifiers());
                stringBuffer.append(constructString+" "+aClass.getSimpleName()+"(");
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                if (parameterTypes.length>0){
                    for (Class<?> parameterType : parameterTypes) {
                        stringBuffer.append(parameterType.getSimpleName()+",");
                    }
                    stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
                }
                stringBuffer.append("){\n\t");

                stringBuffer.append("}\n\n\t");
            }





//            方法
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                String methodModi = Modifier.toString(declaredMethod.getModifiers());
                Class<?> returnType = declaredMethod.getReturnType();
//                方法修饰+方法返回类型+方法名（
                stringBuffer.append(methodModi+" "+returnType.getSimpleName()+" "+declaredMethod.getName()+"(");
                Class<?>[] methodParameters = declaredMethod.getParameterTypes();
//                方法参数
                if (methodParameters.length!=0){
                    for (Class<?> methodParameter : methodParameters) {
                        stringBuffer.append(methodParameter.getSimpleName()+",");
                    }
                    stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
                }

                stringBuffer.append("){\n\t");
//                方法体
                stringBuffer.append("}\n\n\t");
            }
            stringBuffer.append("}");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {

        System.out.println(reflectToString("java.lang.Thread"));
    }
}
