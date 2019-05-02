package com.zking.ssm.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    public static final String DEFAULT_PASSWORD = "888888";

    private Long userId;

    private String username;

    private String password;

    private String salt;

    private Integer locked;

    private java.sql.Timestamp createDatetime;

    public User(Long userId, String username, String password, String salt, Integer locked, java.sql.Timestamp createDatetime) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.locked = locked;
        this.createDatetime = createDatetime;
    }

    public User() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(java.sql.Timestamp createDatetime) {
        this.createDatetime = createDatetime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", locked=" + locked +
                ", createDatetime=" + createDatetime +
                '}';
    }
}