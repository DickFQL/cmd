package annotation.user;

import annotation.main.IdPrivate;
import reversecompile.restoreclass.Test;
import annotation.main.Testannotation;
import java.io.Serializable;
@IdPrivate
@Testannotation(name = "jack", age = 18)
public class User extends Test implements Serializable,Comparable {
    @Testannotation(string = {"123"})
    private int id;
    private String name;
    private int age;
    private String sex;

    private User() {

    }

    public User(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    @Override
    public String toString() {
        return "ThreeReflect{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String printString(String name, Integer age, String sex) {
        return "ThreeReflect{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
