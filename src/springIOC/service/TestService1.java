package springIOC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springIOC.dao.Dao;

//业务层
@Service
public class TestService1 implements ServiceIn{

    @Autowired
    private Dao testDao ;

    public void setTestDao(Dao testDao) {
        this.testDao = testDao;
    }
    @Override
    public void saveAccount(){
        testDao.saveAccount();

    }

}
