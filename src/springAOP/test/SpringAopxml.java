package springAOP.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springAOP.service.ModuleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:xml/aop2.xml")
public class SpringAopxml {

    @Autowired
    private ModuleService moduleService;
    @Test
    public void test01(){
//
        moduleService.getMethod5("jack");
    }
}
