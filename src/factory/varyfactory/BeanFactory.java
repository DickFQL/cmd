package factory.varyfactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

            String className = properties.getProperty("className");
            String[] split = className.split(";");
            for (String string : split) {
                Class<?> aClass = Class.forName(string);
                Object o = aClass.newInstance();
                hashMap.put(aClass.getSimpleName(),o);
            }

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
        }

    }

//    用户获取实例的方法
    public static Object getBean(String key){

        return hashMap.get(key);
    }

}
