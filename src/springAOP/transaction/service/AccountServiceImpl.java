package springAOP.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import springAOP.transaction.dao.AccountDao;


public class AccountServiceImpl implements AccountService{
    @Autowired
    public AccountDao accountDao;



    @Override
    public void updateAccount2() {
        accountDao.updateAccount2();
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


}
