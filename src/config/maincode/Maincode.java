package config.maincode;

import config.SpringConfig;
import config.servlet.TestServlet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Maincode {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Object jDbc = annotationConfigApplicationContext.getBean("JDbc");
        Object emp = annotationConfigApplicationContext.getBean("getEmp");
        TestServlet gSt = (TestServlet) annotationConfigApplicationContext.getBean("gSt");
        gSt.saveAccount();
//        System.out.println(emp);
    }

}
