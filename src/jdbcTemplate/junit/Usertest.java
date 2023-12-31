package jdbcTemplate.junit;

import org.springframework.stereotype.Component;

@Component
public class Usertest {

    private int id;

    private String name;

    public Usertest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Usertest() {
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
