package jdbcTemplate.web.dao;

import jdbcTemplate.junit.User;

import java.util.List;

public interface Dao {
    /**
     * 查询所有用户信息
     */
    List<User> getUserList();
    /**
     * 根据id查询用户信息
     */
    User findUserById(User user);
    /**
     * 添加一个用户
     * @param user
     * @return
     */
    Integer addUser(User user);

    /**
     * 根据id来修改一个用户
     * @param user
     * @return
     */
    Integer updateUserById(User user);
    /**
     * 根据id来删除一个用户
     */
    Integer deleteUserById(User user);
}
