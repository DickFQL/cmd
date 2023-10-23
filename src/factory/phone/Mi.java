package factory.phone;


import factory.annotation.Compent;

@Compent
public class Mi implements Phone{

    public void create(){

        System.out.println("生产了一部小米手机");

    }

}
