package dynamicproxy;

/**
 * 代理类
 * 中介
 */
public class FindHouseProxy implements ProxyInterface{

    private ProxyInterface proxyInterface;
    public FindHouseProxy(ProxyInterface proxyInterface){
        this.proxyInterface = proxyInterface;
    }
    @Override
    public void findHouse() {
        System.out.println("1、看房");
        proxyInterface.findHouse();
        System.out.println("3、售后");
        System.out.println("test");
    }
}
