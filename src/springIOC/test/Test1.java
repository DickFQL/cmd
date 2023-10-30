package springIOC.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springIOC.servlet.TestServlet;

public class Test1 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("xml/bean.xml");
        TestServlet testservlet = classPathXmlApplicationContext.getBean("testservlet", TestServlet.class);
        testservlet.saveAccount();

    }
}
