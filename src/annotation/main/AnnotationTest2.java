package annotation.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Properties;

public class AnnotationTest2 {
    public static void main(String[] args) throws ClassNotFoundException {
//        创建一个properties的集合
        Properties properties = new Properties();
//        创建一个流对象
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("className.properties");
//            读取数据
            properties.load(fileReader);
            String classNames = properties.getProperty("className");
//           分割全类名
            String[] splitArray = classNames.split(";");
//            遍历全类名的数组
            for (String string : splitArray) {
                boolean flag=false;
//            创建字节码对象
                Class<?> aClass = Class.forName(string);
                IdPrivate annotation = aClass.getAnnotation(IdPrivate.class);
                if(annotation != null){
                    Field[] declaredFields = aClass.getDeclaredFields();
                    for (Field declaredField : declaredFields) {
                        if (Modifier.toString(declaredField.getModifiers()).contains("private")&&declaredField.getName().equals("id")){
                            flag=true;
                            break;
                        }
                    }
                    if (flag) {
                        System.out.println(aClass+"检查通过");
                        flag = false;
                    }
                    else {
                        System.out.println(aClass.getName()+"没有包含");
                    }
                }
            }

            System.out.println(fileReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
