package dynamicproxy;

/**
 * 目标类房东
 */
public class FindHouseProxyImpl implements ProxyInterface{
    @Override
    public void findHouse() {
        System.out.println("签合同 ");
    }
}
