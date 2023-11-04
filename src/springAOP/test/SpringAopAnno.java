package springAOP.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springAOP.service.ModuleService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:xml/aopanno.xml")
public class SpringAopAnno {

    @Autowired
    @Qualifier("moduleService2")
    private ModuleService moduleService;
    @Test
    public void test01(){
//
        moduleService.getMethod1();

        moduleService.getMethod2();
        moduleService.getMethod3();

        moduleService.getMethod4();
        moduleService.getMethod5("jack");
    }
}

