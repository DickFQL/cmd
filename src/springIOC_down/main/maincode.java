package springIOC_down.main;

import springIOC_down.Inter.servlet.TestServlet1;
import springIOC_down.factory.ComponentScan;
import springIOC_down.factory.Factory;

public class maincode {
    public static void main(String[] args) {
        ComponentScan comonentScan = new ComponentScan();
        comonentScan.getComponentScan("springIOC_down.Inter");
        TestServlet1 testServlet1 = (TestServlet1) Factory.getBeanMap("testServlet1");
        TestServlet1 testServlet2 = (TestServlet1) Factory.getBeanMap("testServlet1");
        System.out.println(testServlet1 == testServlet2);
        testServlet1.saveAccount();
    }
}
