package springIOC_down.Inter.service;

import springIOC.dao.Dao;
import springIOC_down.annotation.Autowired;
import springIOC_down.annotation.Service;

//业务层
@Service
public class TestService1 implements ServiceIn {

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
