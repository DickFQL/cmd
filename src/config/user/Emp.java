package config.user;

public class Emp {

    private int Id;

    private  String name;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp(int id, String name) {
        Id = id;
        this.name = name;
    }

    public Emp() {
    }

    @Override
    public String toString() {
        return "Emp{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}
