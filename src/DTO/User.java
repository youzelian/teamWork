package DTO;

public class User {
    private int userID;
    private String userName;
    private String userPwd;
    private String realName;
    private String userGender;
    private String userTel;
    
    public User(String username, String password) {
    
    }
    
    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", realName='" + realName + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userTel='" + userTel + '\'' +
                '}';
    }
    
    public User() {
    }
    
    public User(int userID, String userName, String userPwd, String realName, String userGender, String userTel) {
        this.userID = userID;
        this.userName = userName;
        this.userPwd = userPwd;
        this.realName = realName;
        this.userGender = userGender;
        this.userTel = userTel;
    }
    
    public User(String userName, String userPwd, String realName, String userGender, String userTel) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.realName = realName;
        this.userGender = userGender;
        this.userTel = userTel;
    }
    
    public int getUserID() {
        return userID;
    }
    
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getUserPwd() {
        return userPwd;
    }
    
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
    
    public String getRealName() {
        return realName;
    }
    
    public void setRealName(String realName) {
        this.realName = realName;
    }
    
    public String getUserGender() {
        return userGender;
    }
    
    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
    
    public String getUserTel() {
        return userTel;
    }
    
    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }
}
