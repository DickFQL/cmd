package factory.varyfactory;

import factory.phone.Mi;
import factory.phone.Phone;

/**
 * 静态工厂方法模式
 * 生产手机实例
 */
public class PhoneFactory03 {

    public static Phone getMi(){
        return new Mi();
    }

    public static Phone getHuaWei(){
        return new Mi();
    }

    public static Phone getIphone(){
        return new Mi();
    }


}
