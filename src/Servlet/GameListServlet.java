package Servlet;

import DTO.Game;
import Service.GameService;
import utils.pageHelper;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GameListServlet", urlPatterns = "/GameListServlet")
public class GameListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收客户端传递的页码(如果客户端没有传递页码，则默认页码为1，如果传递了则使用客户端传递的页码)
        String num = request.getParameter("pageNum");
        int pageNum = num == null ? 1 : Integer.parseInt(num);
        
        // 2.定义pageSize
        int pageSize = 5;
        
        // 3.调用GameService查询图书信息
        GameService gameService = new GameService();
        pageHelper<Game> gamePageHelper = gameService.listGamesByPage(pageNum, pageSize);
        
        // 4.将查询到的图书信息gamePageHelper存入全局对象application中
        ServletContext shareData = this.getServletContext();
        shareData.setAttribute("gamePageHelper", gamePageHelper);
    }
}
