package day25_springioc.test;


import day25_springioc.pojo.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SprintTest01 {
    public static void main(String[] args) {

        //  加载文件  创建spring核心容器对象
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("xml/bean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("xml/bean.xml"));

//        根据组件的唯一标识来获取实例
           User user2 = beanFactory.getBean("user", User.class);
//           User user1 = classPathXmlApplicationContext.getBean("user",User.class);
//        Student student = classPathXmlApplicationContext.getBean("student", Student.class);
//        System.out.println(user1 == user2);
//        classPathXmlApplicationContext.close();
//        if(user instanceof User) System.out.println("true");

    }


}
