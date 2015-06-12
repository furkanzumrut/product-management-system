package com.furkanzumrut.dao.impl;

import com.furkanzumrut.dao.IProductDao;
import com.furkanzumrut.domain.Product;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by furkanzumrut on 6/7/15.
 */

@Repository("productDao")
@Primary
public class ProductDao implements IProductDao  {

    @Autowired
    private SessionFactory sessionFactory;


    public ProductDao() {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Product product){

        //getting session object from session factory
        Session session = getSessionFactory().getCurrentSession();
        //getting transaction object from session object
        session.beginTransaction();

        session.save(product);
        System.out.println("Inserted Successfully");
        session.getTransaction().commit();
    }


    @Override
    public List<Product> findAll(){
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Product");
        @SuppressWarnings("unchecked")
        List<Product> products = (List<Product>) query.list();
        session.getTransaction().commit();
        return products;
    }

}
