package reflect;

import java.io.*;

public class sc implements Serializable {
    public int age;
    public String name;
    public String sex;
    public String number;
    public int sexNumber;
    public sc(String name,int age,String sex,String number,int sexNumber){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.number = number;
        this.sexNumber = sexNumber;
    }
    public static void startSex(){
        System.out.println("come dick,have a sex");
    }
    @Override
    public String toString() {
        return "Main{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", number='" + number + '\'' +
                ", sexNumber=" + sexNumber +
                '}';
    }
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Runtime.getRuntime().exec("calc.exe");
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        sc sc1 = new sc("小明",18,"man","123456",18);
        FileOutputStream fileOutputStream = new FileOutputStream("test.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(sc1);
        objectOutputStream.close();

//        String string = "test";
//        fileOutputStream.write(string.getBytes());
//        fileOutputStream.close();
        FileInputStream fileInputStream = new FileInputStream("test.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        sc sc2 = (sc) objectInputStream.readObject();
        objectInputStream.close();
    }

}
