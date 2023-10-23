package factory.test;

import factory.varyfactory.Factory;
import factory.varyfactory.PhoneFactory04;
import factory.phone.Phone;

public class Test4 {

    public static void main(String[] args) {
        String string = "factory.phone.HuaWei";

         Factory factory1 = new PhoneFactory04();
        Phone take = factory1.take(string);
        take.create();

    }

}
