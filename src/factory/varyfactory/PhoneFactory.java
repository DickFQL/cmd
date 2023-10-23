package factory.varyfactory;

import factory.phone.HuaWei;
import factory.phone.Iphone;
import factory.phone.Mi;

/**
 * 普通工厂
 * 生产手机实例
 */
public class PhoneFactory {

    public Object getPhone(String name){

        if (name.equals("mi")){

            return new Mi();

        }
          else if(name.equals("HuaWei")){

              return new HuaWei();

        }
          else if (name.equals("Iphone")){
              return new Iphone();
        }

        return null;
    }

}
