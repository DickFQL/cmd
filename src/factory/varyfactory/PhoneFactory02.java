package factory.varyfactory;

import factory.phone.Mi;
import factory.phone.Phone;

/**
 * 工厂方法模式
 * 生产手机实例
 */
public class PhoneFactory02 {

    public Phone getMi(){
        return new Mi();
    }

    public Phone getHuaWei(){
        return new Mi();
    }

    public Phone getIphone(){
        return new Mi();
    }


}
