package springIOC_down.factory;

import springIOC_down.annotation.Autowired;
import springIOC_down.annotation.Controller;
import springIOC_down.annotation.Repository;
import springIOC_down.annotation.Service;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ComponentScan {
    private static List<String> classNameList = new ArrayList<>();
    public static void getComponentScan(String path) {


        path = path.replace(".", "/");
//        获取spring需要扫描的包的路径
        String localPath = ClassLoader.getSystemResource("").getPath() + path;
//        创建文件对象
        File file = new File(localPath);
//        调用过滤文件的方法
        addFile(file);
        //将带有注解的类交给spring管理
        for (String className : classNameList) {
            try {

                Class<?> aClass = Class.forName(className);
                Controller controller = aClass.getAnnotation(Controller.class);
                Service service = aClass.getAnnotation(Service.class);
                Repository repository = aClass.getAnnotation(Repository.class);
                if (controller != null || service != null || repository != null) {
                    Object object = aClass.newInstance();
                    if (controller != null && !controller.value().equals("")) {

                        Factory.getBean().put(controller.value(), object);
                    } else if (service != null && !service.value().equals("")) {
                        Factory.getBean().put(service.value(), object);
                    } else if (repository != null && !repository.value().equals("")) {
                        Factory.getBean().put(repository.value(), object);
                    } else {
                        Factory.getBean().put(lowFirstword(aClass.getSimpleName()), object);
                    }
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        //注入实例的属性

        for (String className : classNameList) {
            try {

                Class<?> aClass = Class.forName(className);
                Controller controller = aClass.getAnnotation(Controller.class);
                Service service = aClass.getAnnotation(Service.class);
                Repository repository = aClass.getAnnotation(Repository.class);
                if (controller != null || service != null || repository != null) {
                    //遍历类中所有的属性
                    Field[] declaredFields = aClass.getDeclaredFields();
                    //遍历属性
                    for (Field declaredField : declaredFields) {
                        //检查属性上有没有自定义注解
                        Autowired autowired = declaredField.getAnnotation(Autowired.class);
                        //如果注解不为空，意味着属性的实例需要注入
                        if(autowired != null){
                            //获取容器中所有的实例
                            Map<String, Object> bean = Factory.getBean();
                            for (Map.Entry<String, Object> stringObjectEntry : bean.entrySet()) {
                                //获取实现类实现接口
                                Class<?>[] interfaces = stringObjectEntry.getValue().getClass().getInterfaces();
                                //遍历接口
                                for (Class<?> anInterface : interfaces) {
                                    //如果接口匹配，就完成注入
                                    if (anInterface == declaredField.getType()){
                                        declaredField.setAccessible(true);
                                        if (controller !=null && !controller.value().equals("")){
                                            declaredField.setAccessible(true);
                                            declaredField.set(Factory.getBeanMap(controller.value()), stringObjectEntry.getValue() );

                                        } else if (controller !=null && controller.value().equals("")) {
                                            String string = lowFirstword(aClass.getSimpleName());
                                            declaredField.set(Factory.getBeanMap(string), stringObjectEntry.getValue() );
                                        }
                                        if (service !=null && !service.value().equals("")){
                                            declaredField.setAccessible(true);
                                            declaredField.set(Factory.getBeanMap(service.value()), stringObjectEntry.getValue() );

                                        }else if (service !=null && service.value().equals("")) {
                                            String string = lowFirstword(aClass.getSimpleName());
                                            declaredField.set(Factory.getBeanMap(string), stringObjectEntry.getValue() );
                                        }
                                        if (repository !=null && !repository.value().equals("")){
                                            declaredField.setAccessible(true);
                                            declaredField.set(Factory.getBeanMap(repository.value()), stringObjectEntry.getValue() );

                                        }
                                        else if (repository !=null && repository.value().equals("")) {
                                            String string = lowFirstword(aClass.getSimpleName());
                                            declaredField.set(Factory.getBeanMap(string), stringObjectEntry.getValue() );
                                        }
                                    }
                                }
                            }
                        }
                    }


                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * 调用过滤文件的方法
     * @param file
     */
    private static void addFile(File file) {
        /**
         * 用于过滤文件的方法 , 获取.class结尾的文件
         */
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(pathname.isDirectory()){
                    addFile(pathname);
                }
                return pathname.getPath().endsWith(".class");
            }
        });

        for (File file1 : files) {
            String path = ClassLoader.getSystemResource("").getPath();
            String substring = path.replace("/", "\\").substring(1);
            String replace = file1.getPath().replace(substring, "");
            String replace1 = replace.replace("\\", ".");
            String replace2 = replace1.replace(".class", "");
            classNameList.add(replace2);
        }

    }
    public static String lowFirstword(String string){
        //将字符串转为字符数组
        Character charArray = string.toCharArray()[0];
        String arrayString = charArray.toString();
        return arrayString.toLowerCase()+string.substring(1);
    }


}
