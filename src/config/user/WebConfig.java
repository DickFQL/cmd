package config.user;


import config.dao.TestDao;
import config.service.TestService;
import config.servlet.TestServlet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean("gSt")
    public TestServlet getServlet(TestService testService){
        TestServlet testServlet = new TestServlet();
        testServlet.setTestService(testService);
        return testServlet;
    }

    @Bean
    public TestService getService(TestDao testDao){
        TestService testService = new TestService();

        return testService;
    }

    @Bean
    public TestDao getDao() {
        TestDao testDao = new TestDao();
        return testDao;
    }

}
