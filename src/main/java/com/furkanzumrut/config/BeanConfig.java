package com.furkanzumrut.config;

import com.furkanzumrut.dao.impl.ProductDao;
import com.furkanzumrut.dao.impl.UserDao;
import com.furkanzumrut.domain.Product;
import com.furkanzumrut.domain.ProductImage;
import com.furkanzumrut.domain.User;
import com.furkanzumrut.service.ProductService;
import com.furkanzumrut.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
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
        sessionBuilder.addAnnotatedClasses(Product.class,User.class, ProductImage.class);
        return sessionBuilder.buildSessionFactory();
    }
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.current_session_context_class","thread");
        // second-level cache:
//        properties.setProperty("hibernate.cache.use_second_level_cache", "true");
//        properties.setProperty("hibernate.cache.use_query_cache","true");
//        properties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.EhCacheRegionFactory");
        return properties;
    }

//    @Bean(name = "validator")
//    public LocalValidatorFactoryBean validator()
//    {
//        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//        bean.setValidationMessageSource(messageSource());
//        return bean;
//    }

//    @Bean
//    public ReloadableResourceBundleMessageSource messageSource() {
//        ReloadableResourceBundleMessageSource resourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
//        resourceBundleMessageSource.setBasename("classpath:/templates/validationMessages/messages");
//        return resourceBundleMessageSource;
//    }

//    @Autowired
//    @Bean(name = "transactionManager")
//    public HibernateTransactionManager getTransactionManager(
//            SessionFactory sessionFactory) {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory);
//        return transactionManager;
//    }




//    @Autowired
//    @Bean(name = "productDao")
//    public ProductDao getProductDao(SessionFactory sessionFactory) {
//        return new ProductDao(sessionFactory);
//    }

//    @Autowired
//    @Bean(name="productService")
//    public ProductService getProductService(ProductDao productDao){ return new ProductService(productDao);}


//    @Autowired
//    @Bean(name= "userDao")
//    public UserDao getUserDao(SessionFactory sessionFactory) { return new UserDao(sessionFactory);}
//
//    @Autowired
//    @Bean(name="userService")
//    public UserService getUserService(UserDao userDao){ return new UserService(userDao);}

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
