package springIOC.dao;

import org.springframework.stereotype.Repository;

@Repository
//持久层
public class TestDao1 implements Dao{

    public void saveAccount(){
        System.out.println("成功连接了数据库，保存了账号");
    }

}
