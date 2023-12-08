package DAO;

import DTO.User;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DruidUtils;

import java.sql.SQLException;
import java.util.List;

public class UserDAO {
    BeanProcessor bean = new GenerousBeanProcessor();
    RowProcessor processor = new BasicRowProcessor(bean);
    // 插入用户信息
    public int insertUser(User user) {
        
        int i = 0;
        try {
            String sql = "insert into users(user_name,user_pwd,real_name,user_gender,user_tel) values(?,?,?,?,?)";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            Object[] params = {user.getUserName(), user.getUserPwd(), user.getRealName(), user.getUserGender(), user.getUserTel()};
            i = queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    
    // 根据用户名查询用户
    public User selectUserByUserName(String userName) {
        User user = null;
        try {
            String sql = "select user_id as userId,user_name as userName,user_pwd as userPwd,real_name as realName,user_gender as userGender,user_tel as userTel " +
                    "from users where user_name=?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            user = queryRunner.query(sql, new BeanHandler<User>(User.class), userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    // 查询所有用户信息
    public List<User> listUser() {
        List<User> userList = null;
        try {
            String sql = "select * from users";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            userList = queryRunner.query(sql, new BeanListHandler<User>(User.class,processor));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
