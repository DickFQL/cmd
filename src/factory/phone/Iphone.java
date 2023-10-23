package factory.phone;

import factory.annotation.Compent;

@Compent
public class Iphone implements Phone{

    public void create(){

        System.out.println("生产了一部苹果手机");

    }

}
