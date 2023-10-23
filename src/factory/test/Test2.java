package factory.test;

import factory.varyfactory.PhoneFactory02;
import factory.phone.Phone;

public class Test2 {

    public static void main(String[] args) {
        PhoneFactory02 phoneFactory02 = new PhoneFactory02();

        Phone mi = phoneFactory02.getMi();
        mi.create();

    }

}
