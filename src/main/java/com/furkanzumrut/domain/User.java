package com.furkanzumrut.domain;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;


/**
 * Created by furkanzumrut on 6/7/15.
 */

@Entity
@Table(name = "t_user")
public class User extends Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    protected Integer userId;

    @Column(name = "user_name")
    @NotEmpty
    @Length(min = 3, max = 40)
    private String userName;

    @Length(min = 3, max = 40)
    @Column(name = "user_mail")
    @NotEmpty
    private String userMail;

    @Length(min = 4, max = 40)
    @Column(name = "user_password")
    @NotEmpty
    private String userPassword;



    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
