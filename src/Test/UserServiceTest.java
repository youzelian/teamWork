package Test;

import DTO.User;
import Service.UserService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService = new UserService();
    
    @Test
    public void checkLogin() {
        User user = userService.checkLogin("nn", "1");
        System.out.println(user);
    }
    @Test
    public void listUser() {
        List<User> userList = userService.listUser();
        System.out.println(userList);
    }
}