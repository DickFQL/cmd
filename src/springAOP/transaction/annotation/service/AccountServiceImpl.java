package springAOP.transaction.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import springAOP.transaction.annotation.dao.AccountDao;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class AccountServiceImpl implements AccountService {
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
