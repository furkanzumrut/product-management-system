
package com.furkanzumrut.controller;

import com.furkanzumrut.Application;
import com.furkanzumrut.domain.Product;
import com.furkanzumrut.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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


    @Before
    public void setUp(){
        productServiceMock = mock(ProductService.class);;
    }


    @Test
	public void saveProduct_Test() throws Exception {
        Product p = new Product();
        p.setPrice(1000);
        p.setId(1);
        p.setName("Iphone");
        productServiceMock.saveProduct(p);
        Mockito.verify(productServiceMock);
    }

   @Test
   public void getAllProduct_Test()  throws Exception {
       Mockito.when(productServiceMock.getAllProducts());
   }


}
