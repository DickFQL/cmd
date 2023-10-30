package springIOC_down.Inter.servlet;


import springIOC.service.ServiceIn;
import springIOC_down.annotation.Autowired;
import springIOC_down.annotation.Controller;

@Controller
//表现层主要处理请求和响应
public class TestServlet1 implements Servelet {
    @Autowired
    private ServiceIn testService1;

    public void setTestService(ServiceIn testService) {
        this.testService1 = testService;
    }
    @Override
    public void saveAccount(){
        testService1.saveAccount();
    }
}
