package dynamicproxy.jdk;

public class ProxyImpl implements ProxyInterface{
    public void eat(String food){
        System.out.println("今天中午吃"+food);
    }
}
