package Servlet;

import DTO.Game;
import Service.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "gameSaveServlet", urlPatterns = "/gameSaveServlet")
@MultipartConfig
public class gameSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接受输入的游戏信息
        request.setCharacterEncoding("utf-8");
        String gameName = request.getParameter("gameName");
        String gameDetail = request.getParameter("gameDetail");
        double gamePrice = Double.parseDouble(request.getParameter("gamePrice"));
        String gameType = request.getParameter("gameType");
        String gameLink = request.getParameter("gameLink");
        
        // 2.接受并保存游戏的封面图片
        // 2.1重新赋名
        // a.获取后缀名
        Part gameImg = request.getPart("gameImg");
        String header = gameImg.getHeader("Content-Disposition");
        String ext = header.substring(header.lastIndexOf("."), header.lastIndexOf("\""));
        // b.使用随机数重新赋名
        String fileName = UUID.randomUUID().toString() + ext;
        // 2.2获取imgs目录在服务器上的路径
        String dir = getServletContext().getRealPath("/gameFile/imgs");
        System.out.println(dir);
        String savePath = dir + "\\" + fileName;
        System.out.println(savePath);
        // 2.3保存图片
        gameImg.write(savePath);
        
        // 3.调用BookService将图书信息保存到数据库
        Game game = new Game(gameName, gameDetail, gameType, "gameFile/imgs/" + fileName, gameLink, gamePrice);
        GameService gameService = new GameService();
        boolean b = gameService.saveGame(game);
        
        // 4.跳转到提示页面然后跳转到主页面index.jsp，并显示提示信息
        String tips = b ? "<label style='color:green'>游戏信息添加成功!</label>" : "<label style='color:red'>游戏信息添加失败!</label>";
        String type = "gameSave";
        String address = "主页面";
        request.setAttribute("tips", tips);
        request.setAttribute("type", type);
        request.setAttribute("address", address);
        request.getRequestDispatcher("prompt.jsp").forward(request, response);
    }
}
