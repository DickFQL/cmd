package springAOP.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springAOP.transaction.annotation.service.AccountService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:xml/aopmanageanno.xml")
public class SpringAopManAnno {

    @Autowired
    private AccountService accountService;
    @Test
    public void test01(){
//
        accountService.updateAccount2();

    }
}

