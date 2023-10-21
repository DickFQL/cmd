package annotation.main;

import java.lang.reflect.Field;

public class AnnotationTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("annotation.user.Student");
        Field[] name = aClass.getDeclaredFields();
        for (Field field : name) {
            Testannotation2 annotation = field.getAnnotation(Testannotation2.class);
            System.out.println(annotation);
        }
    }
}
