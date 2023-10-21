package reflect;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Scanner;
public class CTFser implements Serializable
{
    private String code;
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Runtime.getRuntime().exec(this.code);
    }
    public static void Serialize(Object obj) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("11.txt"));
        out.writeObject(obj);
        out.close();
    }
    public static void Unserialize(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream In = new ObjectInputStream(new FileInputStream(path));
        Object obj= In.readObject();
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        CTFser ctFser = new CTFser();
        Field f = Class.forName("reflect.CTFser").getDeclaredField("code");
        f.setAccessible(true);
        f.set(ctFser,"calc.exe");
//        System.out.println(ctFser);
        Serialize(ctFser);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your filePath: ");
        String filePath = scanner.nextLine();

        Unserialize(filePath);
    }
}