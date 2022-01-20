package com.example.securingweb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table
public class LoginToken {

    @Id
    private String username;

    @Column(nullable = false)
    private Date timeOfLogin;

    public LoginToken(String username, Timestamp timeOfLogin) {
        this.username = username;
        this.timeOfLogin = timeOfLogin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTimeOfLogin() {
        return timeOfLogin;
    }

    public void setTimeOfLogin(Timestamp timeOfLogin) {
        this.timeOfLogin = timeOfLogin;
    }
}
