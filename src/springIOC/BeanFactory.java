package springIOC;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Properties;

public class BeanFactory {

    static HashMap<String,Object> hashMap;

    static {
//        存放实例
        hashMap= new HashMap<>();
//      创建properties
        Properties properties = new Properties();

//        创建一个流对象
        try {
            FileReader fileReader = new FileReader("class.properties");
            properties.load(fileReader);

            String servlet = properties.getProperty("servlet");
            String service = properties.getProperty("service");
            String dao = properties.getProperty("dao");
            Class<?> aClass = Class.forName(servlet);
            Object o = aClass.newInstance();
            Class<?> aClass1 = Class.forName(service);
            Object o1 = aClass1.newInstance();
            Class<?> aClass2 = Class.forName(dao);
            Object o2 = aClass2.newInstance();
            Field declaredField = aClass1.getDeclaredField("testDao");
            declaredField.setAccessible(true);
            declaredField.set(o1,o2);
            Field declaredField1 = aClass.getDeclaredField("testService");
            declaredField1.setAccessible(true);
            declaredField1.set(o,o1);
            hashMap.put(aClass.getSimpleName(),o);
            hashMap.put(aClass1.getSimpleName(),o1);
            hashMap.put(aClass2.getSimpleName(),o2);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }

//    用户获取实例的方法
    public static Object getBean(String key){

        return hashMap.get(key);

    }

    public static HashMap<String, Object> getHashMap() {
        return hashMap;
    }
}
