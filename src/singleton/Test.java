package singleton;

public class Test {
//    当前类组合当前类的引用
    private static final Test test1 = new Test();
//   构造私有化
    private Test(){}
//  提供私有化，对当前类的实例提供获取
    public Test getInstance(){
        return test1;
    }
    public static void main(String[] args) {
        Test test = new Test().getInstance();
        Test test2 = new Test().getInstance();
        System.out.println(test == test2);
    }
}
