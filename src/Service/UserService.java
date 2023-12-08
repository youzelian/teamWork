package Service;

import DAO.UserDAO;
import DTO.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();
    
    // 添加用户信息
    public boolean saveUser(User user) {
        int i = userDAO.insertUser(user);
        return i > 0 ? true : false;
    }
    
    // 检验用户是否存在
    public User checkUser(String userName) {
        User user = userDAO.selectUserByUserName(userName);
        if (user == null) {
            return null;
        } else {
            return user;
        }
    }
    
    // 检验用户名是否存在及用户密码是否正确
    public User checkLogin(String userName, String userPwd) {
        // 1.根据userName查询管理员信息
        User user = userDAO.selectUserByUserName(userName);
        if (user == null) {
            return null;
        } // 2.判断密码
        else if (user.getUserPwd().equals(userPwd)) {
            return user;
        } else {
            return null;
        }
    }
    
    // 查询所有用户
    public List<User> listUser() {
        List<User> userList = userDAO.listUser();
        return userList;
    }
}
