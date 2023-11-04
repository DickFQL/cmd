package springAOP.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springAOP.proxy.CreateProxy;
import springAOP.service.ModuleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:xml/aop.xml")
public class SpringAopTest {

    @Autowired
    private CreateProxy createProxy;

    @Test
    public void test01(){
//        获取代理对象
        ModuleService proxy = (ModuleService) createProxy.getProxy();
        proxy.getMethod1();
        proxy.getMethod2();
        proxy.getMethod3();
        proxy.getMethod4();
//        proxy.getMethod5();

    }
}
