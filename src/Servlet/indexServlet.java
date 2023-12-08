package Servlet;

import DTO.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "indexServlet", urlPatterns = "/indexServlet")
public class indexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // response.setContentType("text/html;charset=utf-8");
        // HttpSession session = request.getSession();
        // User user = (User) session.getAttribute("user");
        // if (user == null) {
        //     response.sendRedirect("login.jsp");
        // } else {
        //     // 创建Cookie存放Session的标识号
        //     Cookie cookie = new Cookie("JSESSIONID", session.getId());
        //     cookie.setMaxAge(60 * 60 * 24);
        //     response.addCookie(cookie);
        // }
        
    }
}
