package com.furkanzumrut.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Collection;

/**
 * Created by furkanzumrut on 6/7/15.
 */


@Entity
@Table(name="t_product")
public class Product extends NamedEntity{

    @NotNull
    @Max(10000000)
    @Column(name="price")
    private int price;

    @Column(name="user_name")
    private String userName;


    public Product(){

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
