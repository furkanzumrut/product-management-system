package com.furkanzumrut.service;

import com.furkanzumrut.domain.Product;

import java.util.List;

/**
 * Created by furkanzumrut on 6/7/15.
 */
public interface IProductService {
    List<Product> getAllProducts();
    void saveProduct(Product product);
}
