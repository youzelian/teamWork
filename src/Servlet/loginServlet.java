package Servlet;

import DTO.User;
import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "loginServlet", urlPatterns = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接受账号和密码
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String inputVcode = request.getParameter("inputVcode");
        // 2.调用userService校验登录
        UserService userService = new UserService();
        User user = userService.checkLogin(userName, userPwd);
        //  校验验证码
        // 从session中得到验证码
        String codes = (String) request.getSession().getAttribute("codes");
        // 验证码非空判断且验证码不区分大小写
        if (!inputVcode.isEmpty() && inputVcode.equalsIgnoreCase(codes)) {
            // 4.判断user是否为空
            if (user == null) {
                // 登录失败，显示提示信息
                request.setAttribute("tips", "<label style='color:red;'>账号或密码错误，请重新登录!</label>");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            else {
                // 登录成功，将用户信息存储到Session中
                //编码是为了在cookie中存储汉字
                String usernameCode = URLEncoder.encode(userName, "UTF-8");
                Cookie cookie = new Cookie("cookieAuto", usernameCode + '-' + userPwd);
                //设置持久化时间
                cookie.setMaxAge(60 * 60);
                //发送cookie
                response.addCookie(cookie);
                request.setAttribute("cookieName", cookie.getName());
                // 重定向到index.jsp
                response.sendRedirect("GameListServlet");
            }
        }
        else {
            request.setAttribute("tips", "<label style='color:red;'>验证码错误!</label>");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
