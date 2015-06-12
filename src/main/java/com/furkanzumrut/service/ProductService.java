package com.furkanzumrut.service;


import com.furkanzumrut.dao.impl.ProductDao;
import com.furkanzumrut.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by furkanzumrut on 6/7/15.
 */

@Service("productService")
@Primary
public class ProductService implements IProductService {

    @Autowired
    private ProductDao productDao;


    public ProductService(){

    }


    public void setProductDao(ProductDao productDao) {
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
