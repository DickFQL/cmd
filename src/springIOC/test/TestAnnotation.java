package springIOC.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springIOC.servlet.TestServlet1;

public class TestAnnotation {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("xml/bean2.xml");

        TestServlet1 testServlet1 = classPathXmlApplicationContext.getBean("testServlet1", TestServlet1.class);
        testServlet1.saveAccount();

    }
}
