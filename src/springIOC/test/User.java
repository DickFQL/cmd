package springIOC.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "User")
public class User {
    @Value("18")
    private int id;

    @Value("张三")
    private  String name;
    public User(){}
    public User(int id, String name) {

        this.id = id;
        this.name = name;
    }
    public void init(){
        System.out.println("容器创建成功");
    }
    public void destory(){
        System.out.println("容器销毁成功");
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
