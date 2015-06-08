package com.furkanzumrut.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;

/**
 * Created by furkanzumrut on 6/7/15.
 */
public class User  extends Person{

    @Column(name = "user_name")
    @NotEmpty
    @Length(min = 3,max = 40)
    private String userName;

    @Length(min = 3,max = 40)
    @Column(name = "user_mail")
    private String userMail;

    @Length(min = 4,max = 40)
    @Column(name = "user_password")
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
}
