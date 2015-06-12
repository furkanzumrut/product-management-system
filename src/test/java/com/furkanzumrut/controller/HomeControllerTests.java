package com.furkanzumrut.controller;

import com.furkanzumrut.Application;
import com.furkanzumrut.domain.Product;
import com.furkanzumrut.domain.User;
import com.furkanzumrut.service.ProductService;
import com.furkanzumrut.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration(value = ".")
public class HomeControllerTests {


    private ProductService productServiceMock;
    private UserService userServiceMock;

    @Autowired
    private ProductService productService;

    @Before
    public void setUp() {
        productServiceMock = mock(ProductService.class);
        userServiceMock = mock(UserService.class);
    }


    @Test
    public void saveUser_Test() throws Exception {
        User u = new User();
        u.setUserMail("furkan@furkanzumrut.com");
        u.setUserName("furkanzumrut");
        u.setUserPassword("123456");
        u.setAge(22);
        u.setFirstName("Furkan");
        u.setLastName("Zumrut");
        u.setGender("Male");
        userServiceMock.saveUser(u);

    }
    @Test
	public void saveProduct_Test() throws Exception {
        User u = new User();
        u.setUserMail("furkan@furkanzumrut.com");
        u.setUserName("furkanzumrut");
        u.setUserPassword("123456");
        u.setAge(22);
        u.setFirstName("Furkan");
        u.setLastName("Zumrut");
        u.setGender("Male");
        u.setUserId(1);
        Product p = new Product();
        p.setPrice(1000);
        p.setId(1);

        p.setName("Iphone");

        productServiceMock.saveProduct(p);

    }

    @Test
    public void getAllProduct_Test() throws Exception {
        List<Product> productList = productService.getAllProducts();
//        Assert.assertEquals(productList.get(1).getUserId(),1);


    }


}
