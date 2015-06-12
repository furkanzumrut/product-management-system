package com.furkanzumrut.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Date;
import java.util.Collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by furkanzumrut on 6/7/15.
 */


@Entity
@Table(name="t_product")
public class Product extends NamedEntity{

    @NotNull
    @Column(name="price")
    private double price = 0.0;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_id")
    private int userId;

    @Column(name="amount")
    private int amount = 1;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<ProductImage> productImages = new HashSet<ProductImage>(
            0);


    @Temporal(TemporalType.DATE)
    @Column(name = "added_date", unique = true, nullable = false, length = 10)
    private Date date;

    public Product(){

    }

    public double getPrice() {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Set<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(Set<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
