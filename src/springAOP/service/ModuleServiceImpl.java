package springAOP.service;


import org.springframework.stereotype.Service;

@Service
public class ModuleServiceImpl implements ModuleService{


    @Override
    public void getMethod1() {
        System.out.println("核心方法1");
    }

    @Override
    public void getMethod2() {
        System.out.println("核心方法2");

    }

    @Override
    public void getMethod3() {
        System.out.println("核心方法3");

    }

    @Override
    public void getMethod4() {
        System.out.println("核心方法4");

    }

    @Override
    public void getMethod5(String name) {
        System.out.println("核心方法5"+name);
    }
}
