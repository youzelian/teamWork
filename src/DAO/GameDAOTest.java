package DAO;

import DTO.Game;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GameDAOTest {
    private GameDAO gameDAO = new GameDAO();
    
    @Test
    public void selectGames() {
        List<Game> games = gameDAO.selectGames(0, 1);
        System.out.println(games);
    }
}