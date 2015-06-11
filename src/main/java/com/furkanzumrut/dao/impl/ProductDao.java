package com.furkanzumrut.dao.impl;

import com.furkanzumrut.dao.IProductDao;
import com.furkanzumrut.domain.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by furkanzumrut on 6/7/15.
 */
public class ProductDao implements IProductDao  {


    private SessionFactory sessionFactory;

    @Autowired
    public ProductDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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
        Criteria criteria = session.createCriteria(Product.class);

        @SuppressWarnings("unchecked")
        List<Product> products = (List<Product>) criteria.list();
        session.getTransaction().commit();
        return products;
    }

}
