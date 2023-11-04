package jdbcTemplate.web.service;

import jdbcTemplate.junit.User;
import jdbcTemplate.web.dao.Dao;

import java.util.List;

//业务层

public class TestService implements ServiceIn {


    private Dao testDao ;

    public void setTestDao(Dao testDao) {
        this.testDao = testDao;
    }

    @Override
    public List<User> getUserList() {
        return testDao.getUserList();
    }

    @Override
    public User findUserById(User user) {
        return testDao.findUserById(user);
    }

    @Override
    public Integer addUser(User user) {
        return testDao.addUser(user);
    }

    @Override
    public Integer updateUserById(User user) {
        return testDao.updateUserById(user);
    }

    @Override
    public Integer deleteUserById(User user) {
        return  testDao.deleteUserById(user);
    }
}
