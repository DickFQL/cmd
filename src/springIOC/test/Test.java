package springIOC.test;

import factory.varyfactory.BeanFactory;
import springIOC.servlet.TestServlet1;

public class Test {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory();

        TestServlet1 testServlet1 = (TestServlet1) beanFactory.getBean("TestServlet1");
        testServlet1.saveAccount();
//        HashMap<String,Object> hashMap = BeanFactory.getHashMap();

//        HashMap遍历，用HashMap.entrySet()

//        Set<Map.Entry<String, Object>> entries = hashMap.entrySet();
//        for (Map.Entry<String, Object> entry : entries) {
//            System.out.println(entry+"\n");
//        }
    }
}
