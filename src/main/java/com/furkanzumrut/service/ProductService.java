package com.furkanzumrut.service;


import com.furkanzumrut.dao.impl.ProductDao;
import com.furkanzumrut.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by furkanzumrut on 6/7/15.
 */
public class ProductService implements IProductService {


    private ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public void saveProduct(Product product){
        productDao.save(product);
    }


}
