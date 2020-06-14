package org.fjnu.springboot.bean;

/**
 * @author wb_Lin
 * @create 2020-04-12 11:54
 */
public class User {
    private String username;
    private String password;
    private String nickname;
    private  String avator;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String nickname, String avator) {
        this.username = username;
        this.nickname = nickname;
        this.avator = avator;
    }

    public User(String username, String password, String nickname, String avator) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.avator = avator;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
