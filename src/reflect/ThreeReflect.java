package reflect;

import java.lang.reflect.*;

public class ThreeReflect {
    private String name;

    private int age;
    private String sex;

    public ThreeReflect() {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public ThreeReflect(String name,int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    @Override
    public String toString() {
        return "ThreeReflect{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String printString(String name, Integer age, String sex) {
        return "ThreeReflect{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {
//        三种获取字节码对象
//1        1
        Class<?> aClass = Class.forName("reflect.ThreeReflect");
        Method toString = aClass.getMethod("printString",String.class,Integer.class,String.class);
        Method toString1 = aClass.getMethod("toString");
        Object o = aClass.newInstance();
        ThreeReflect threeReflect = new ThreeReflect();
        threeReflect.setName("蓝天");
        threeReflect.setAge(10);
        threeReflect.setSex("男");
        System.out.println(toString.invoke(threeReflect,"蓝天",18,"男"));
        System.out.println(toString1.invoke(threeReflect));
//2
        System.out.println(new ThreeReflect().getClass().getDeclaredMethod("printString", String.class, Integer.class, String.class).invoke(threeReflect,"白云",18,"女"));
//3
        Class<ThreeReflect> threeReflectClass = ThreeReflect.class;
        System.out.println("——————————————————");
//        获取属性字节码对象
        Field name1 = aClass.getDeclaredField("name");
//        打破封装
        name1.setAccessible(true);
        name1.set(threeReflect,"小丑");
        System.out.println(threeReflect.getName());
        aClass.getDeclaredMethod("setName", String.class).invoke(threeReflect,"校花");
        System.out.println(threeReflect.getName());
        System.out.println("————————————");
//        获取所有属性字节码对象
//        Field[] declaredFields = aClass.getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            System.out.println(declaredField.getName());
//            System.out.println(declaredField.getType());
//            int modifiers = declaredField.getModifiers();
//            System.out.println(modifiers);
//            String string = Modifier.toString(modifiers);
//            System.out.println(string+"\n");
//        }
        System.out.println(name1.get(threeReflect));
        System.out.println("——————————————————————");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        Object o1 = declaredConstructor.newInstance();
        System.out.println("上面是无参构造");
        Constructor<?> declaredConstructor1 = aClass.getDeclaredConstructor(String.class,int.class,String.class);
        Object o2 = declaredConstructor1.newInstance("阿伟",18,"男");
        System.out.println("这是有参构造："+o2);

    }
}
