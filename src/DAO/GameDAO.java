package DAO;

import DTO.Game;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DruidUtils;

import java.sql.SQLException;
import java.util.List;

public class GameDAO {
    // 保存所有游戏
    public int insertGame(Game game) {
        int i = 0;
        try {
            String sql = "insert into games(game_name,game_detail,game_type,game_img_path,game_link,game_price)\n" +
                    "values(?,?,?,?,?,?)";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            Object[] params = {game.getGameName(), game.getGameDetail(), game.getGameType(), game.getGameImgPath(), game.getGameLink(), game.getGamePrice()};
            i = queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    
    /**
     * 查询所有游戏
     *
     * @param start
     * @param limit
     * @return
     */
    public List<Game> selectGames(int start, int limit) {
        List<Game> gameList = null;
        try {
            String sql = "select game_id as gameId,game_name as gameName,game_detail as gameDetail,game_type as gameType,game_img_path as gameImgPath,game_link as gameLink,game_price as gamePrice from games limit ?,?";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            BeanListHandler<Game> BeanListHandler = new BeanListHandler<Game>(Game.class);
            gameList = queryRunner.query(sql, BeanListHandler, start, limit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gameList;
    }
    
    /**
     * 查询游戏总记录数
     *
     * @return
     */
    public Long selectGameCount() {
        long count = 0;
        try {
            String sql = "select count(1) from games";
            QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
            count = queryRunner.query(sql, new ScalarHandler<Long>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}