package DTO;

public class Game {
    private int gameId;
    private String gameName;
    private String gameDetail;
    private String gameType;
    private String gameImgPath;
    private String gameLink;
    private Double gamePrice;
    
    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", gameName='" + gameName + '\'' +
                ", gameDetail='" + gameDetail + '\'' +
                ", gameType='" + gameType + '\'' +
                ", gameImgPath='" + gameImgPath + '\'' +
                ", gameLink='" + gameLink + '\'' +
                ", gamePrice=" + gamePrice +
                '}';
    }
    
    public Game() {
    }
    
    public Game(String gameName, String gameDetail, String gameType, String gameImgPath, String gameLink, Double gamePrice) {
        this.gameName = gameName;
        this.gameDetail = gameDetail;
        this.gameType = gameType;
        this.gameImgPath = gameImgPath;
        this.gameLink = gameLink;
        this.gamePrice = gamePrice;
    }
    
    public int getGameId() {
        return gameId;
    }
    
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
    
    public String getGameName() {
        return gameName;
    }
    
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
    
    public String getGameDetail() {
        return gameDetail;
    }
    
    public void setGameDetail(String gameDetail) {
        this.gameDetail = gameDetail;
    }
    
    public String getGameType() {
        return gameType;
    }
    
    public void setGameType(String gameType) {
        this.gameType = gameType;
    }
    
    public String getGameImgPath() {
        return gameImgPath;
    }
    
    public void setGameImgPath(String gameImgPath) {
        this.gameImgPath = gameImgPath;
    }
    
    public String getGameLink() {
        return gameLink;
    }
    
    public void setGameLink(String gameLink) {
        this.gameLink = gameLink;
    }
    
    public Double getGamePrice() {
        return gamePrice;
    }
    
    public void setGamePrice(Double gamePrice) {
        this.gamePrice = gamePrice;
    }
}
