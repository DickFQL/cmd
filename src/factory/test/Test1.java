package factory.test;

import factory.varyfactory.PhoneFactory;
import factory.phone.HuaWei;
import factory.phone.Mi;

public class Test1 {

    public static void main(String[] args) {
        PhoneFactory phoneFactory = new PhoneFactory();

        Mi mi = (Mi)phoneFactory.getPhone("mi");
        HuaWei huaWei = (HuaWei) phoneFactory.getPhone("HuaWei");
        huaWei.create();
        mi.create();
    }

}
