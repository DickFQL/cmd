package config.dao;


import org.springframework.stereotype.Repository;

//持久层
@Repository
public class TestDao implements Dao {

    public void saveAccount(){
        System.out.println("成功连接了数据库，保存了账号");
    }

}
