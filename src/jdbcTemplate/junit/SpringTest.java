package jdbcTemplate.junit;

import jdbcTemplate.web.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @RunWith 可以替换运行器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/xml/jdbcaTemplate.xml"})
//@ContextConfiguration(classes = ConfigStu.class)
public class SpringTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private TestService testService;
    @Test
    public void test01(){

        Usertest user = applicationContext.getBean("user", Usertest.class);

        System.out.println(user);

        System.out.println("当前程序可以正常进行");
    }

    @Test
    public void test02(){
        Object student = applicationContext.getBean("getstu");
        System.out.println(student);

    }
    /**
     * 添加用户
     */
    @Test
    public void testAdd(){
//        增加用户
//        testService.addUser(new User("tome","123456"));
//        删除用户
//        testService.deleteUserById(new User(7));
//        修改用户
//        testService.updateUserById(new User(8,"tome","12345677"));
//        查询全部信息
//        List<User> userList = testService.getUserList();
//        for (User user : userList) {
//            System.out.println(user);
//        }
//        System.out.println(testService);
//       精准查询
        User userById = testService.findUserById(new User(5));
        System.out.println(userById);

    }
}
