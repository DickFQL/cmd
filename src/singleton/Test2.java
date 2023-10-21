package singleton;

public class Test2 {
    private  static Test2 test2;
    static {
        test2 = new Test2();
    }
    private Test2(){}
    public Test2 getTest2(){
        return test2;
    }
}
