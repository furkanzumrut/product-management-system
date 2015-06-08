package com.furkanzumrut.config;

import com.furkanzumrut.dao.impl.ProductDao;
import com.furkanzumrut.domain.Product;
import com.furkanzumrut.service.ProductService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by furkanzumrut on 6/8/15.
 */
@Configuration
public class BeanConfig {

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addProperties(getHibernateProperties());
        sessionBuilder.addAnnotatedClasses(Product.class);
        return sessionBuilder.buildSessionFactory();
    }
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hbm2ddl.auto","create");
        properties.put("hibernate.current_session_context_class","thread");
        return properties;
    }

//    @Autowired
//    @Bean(name = "transactionManager")
//    public HibernateTransactionManager getTransactionManager(
//            SessionFactory sessionFactory) {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory);
//        return transactionManager;
//    }




    @Autowired
    @Bean(name = "productDao")
    public ProductDao getProductDao(SessionFactory sessionFactory) {
        return new ProductDao(sessionFactory);
    }

    @Autowired
    @Bean(name="productService")
    public ProductService getProductService(ProductDao productDao){ return new ProductService(productDao);}

    @Bean(name = "dataSource")
    public DataSource getDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/productmandb");
        dataSource.setUsername("root");
        dataSource.setPassword("root");


        return dataSource;
    }
}
