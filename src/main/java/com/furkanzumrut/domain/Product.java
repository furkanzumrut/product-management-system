package com.furkanzumrut.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;

/**
 * Created by furkanzumrut on 6/7/15.
 */


@Entity
@Table(name="T_PRODUCT")
public class Product extends NamedEntity{

    @NotNull
    @Max(10000000)
    private int price;

    public Product(){

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
