package springIOC.servlet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import springIOC.service.ServiceIn;

@Controller
//表现层主要处理请求和响应
public class TestServlet1 implements Servelet{

    @Autowired
    @Qualifier("testService1")
    private ServiceIn testservice1;

    public void setTestService(ServiceIn testService) {
        this.testservice1 = testService;
    }
    @Override
    public void saveAccount(){
        testservice1.saveAccount();
    }
}
