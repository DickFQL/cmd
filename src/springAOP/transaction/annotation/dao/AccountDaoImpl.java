package springAOP.transaction.annotation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public void updateAccount2() {
        int update = jdbcTemplate.update("update account set accountA=accountA - ? where id=?", 1000, 1);
        System.out.println(update == 1?"A转账成功":"失败");
        int i = 1/0;
        update = jdbcTemplate.update("update account set accountB = accountB + ? where id=?", 1000, 1);
        System.out.println(update == 1?"B转账成功":"失败");

    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
