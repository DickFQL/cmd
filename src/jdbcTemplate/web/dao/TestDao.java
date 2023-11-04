package jdbcTemplate.web.dao;


import jdbcTemplate.junit.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//持久层

public class TestDao implements Dao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> getUserList() {
        return jdbcTemplate.query("select * from users ", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User(id, username, password);
                return user;
            }
        });
    }

    @Override
    public User findUserById(User user) {
        return jdbcTemplate.query("select * from users  where id=?",new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User(id, username, password);
                return user;
            }
        }, user.getId()).get(0);
    }

    @Override
    public Integer addUser(User user) {
        return jdbcTemplate.update("insert into users(username,password) values (?,?)",user.getUsername(),user.getPassword());

    }

    @Override
    public Integer updateUserById(User user) {
        return  jdbcTemplate.update("update users set username= ?,password=? where id=?",user.getUsername(),user.getPassword(),user.getId());
    }

    @Override
    public Integer deleteUserById(User user) {
        return jdbcTemplate.update("delete from users where id=?",user.getId());
    }
}
