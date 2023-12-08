package Service;

import DAO.GameDAO;
import DTO.Game;
import utils.pageHelper;

import java.util.List;

public class GameService {
    private GameDAO gameDAO = new GameDAO();
    
    /**
     * 保存游戏
     *
     * @param game
     * @return
     */
    public boolean saveGame(Game game) {
        int i = gameDAO.insertGame(game);
        return i > 0 ? true : false;
    }
    
    /**
     * 分页查询所有游戏
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public pageHelper<Game> listGamesByPage(int pageNum, int pageSize) {
        // 1.查询当前页码的信息
        int start = (pageNum - 1) * pageSize;
        int limit = pageSize;
        List<Game> bookList = gameDAO.selectGames(start, limit);
        // 查询并计算图书总页数
        // a.查询总记录数
        GameDAO gameDAO = new GameDAO();
        Long count = gameDAO.selectGameCount();
        // b.根据总记录数和每页条数，计算总页数
        long pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        // 3. 将分页数据都放在一个pageHelper对象中
        pageHelper<Game> bookPageHelper = new pageHelper<Game>(bookList, pageNum, (int) pageCount);
        return bookPageHelper;
    }
}
