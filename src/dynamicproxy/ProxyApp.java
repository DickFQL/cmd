package dynamicproxy;

public class ProxyApp {
    public static void main(String[] args) {
//        创建一个中介对象
        FindHouseProxy findHouseProxy = new FindHouseProxy(new FindHouseProxyImpl());
        findHouseProxy.findHouse();
    }
}
