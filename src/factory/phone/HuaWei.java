package factory.phone;


import factory.annotation.Compent;

@Compent
public class HuaWei implements Phone{

    public void create(){

        System.out.println("生产了一部华为手机");

    }

}
