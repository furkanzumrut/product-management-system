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




    public Product(){

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }
}
