package config.service;

import config.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//业务层
@Service
public class TestService implements ServiceIn {

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
