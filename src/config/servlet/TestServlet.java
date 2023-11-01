package config.servlet;


import config.service.ServiceIn;

//表现层主要处理请求和响应
public class TestServlet {

    private ServiceIn testService;

        public void setTestService(ServiceIn testService) {
        this.testService = testService;
    }

    public void saveAccount(){
        testService.saveAccount();
    }
}
