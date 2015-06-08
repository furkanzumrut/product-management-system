package com.furkanzumrut.dao;

import com.furkanzumrut.domain.Product;

import java.util.List;

/**
 * Created by furkanzumrut on 6/7/15.
 */
public interface IProductDao {
    void save(Product product);
    List<Product> findAll();

}
