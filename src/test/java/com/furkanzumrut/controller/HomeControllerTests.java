
package com.furkanzumrut.controller;

import com.furkanzumrut.Application;
import com.furkanzumrut.domain.Product;
import com.furkanzumrut.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration(value = ".")
public class HomeControllerTests {


    private ProductService productServiceMock;

    @Autowired
    private ProductService productService;



	@Test
	public void test_index() throws Exception {
        productServiceMock = mock(ProductService.class);
        Product p = new Product();
        p.setPrice(1000);
        p.setId(1);
        p.setName("Iphone");
        productServiceMock.saveProduct(p);
    }

    @Test
    public void test_index_without_mock() throws Exception {

        Product p = new Product();
        p.setPrice(1000);
        p.setId(1);
        p.setName("Iphone");
        productService.saveProduct(p);
    }
//
//	@Test
//	public void test_post() throws Exception {
//		mvc.perform(post("/").param("text", "Hello")).andExpect(status().isOk()).andExpect(
//				content().string(new Contains("<li>Hello</li>")));
//	}

}
