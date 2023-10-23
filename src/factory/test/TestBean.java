package factory.test;

import factory.varyfactory.BeanFactory;

public class TestBean {
    public static void main(String[] args) {

        Object huaWei = BeanFactory.getBean("HuaWei");
        System.out.println(huaWei);
    }
}
