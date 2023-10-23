package factory.varyfactory;

import factory.phone.Phone;

/**
 * 静态工厂方法模式
 * 生产手机实例
 */
public class PhoneFactory04 implements Factory {


    @Override
    public Phone take(String string) {
        try {
            Class<?> aClass = Class.forName(string);
            Object create = aClass.newInstance();
            return create instanceof Phone ? (Phone) create:null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }  catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
