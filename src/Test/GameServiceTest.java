package Test;

import DAO.GameDAO;
import DTO.Game;
import org.junit.Test;

import java.nio.channels.Pipe;
import java.util.List;

import static org.junit.Assert.*;

public class GameServiceTest {
    private GameDAO gameDAO = new GameDAO();
    
    @Test
    public void listGamesByPage() {
        List<Game> games = gameDAO.selectGames(0, 1);
        System.out.println(games);
    }
}