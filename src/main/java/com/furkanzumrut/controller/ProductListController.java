
package com.furkanzumrut.controller;

import com.furkanzumrut.domain.Product;
import com.furkanzumrut.service.IProductService;
import net.rossillo.spring.web.mvc.CacheControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by furkanzumrut on 6/8/15.
 */
@Controller
@RequestMapping("/products")
public class ProductListController {


    @Autowired
    protected IProductService productService;

    @CacheControl(maxAge = 300)
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getProducts() {
        ModelAndView mav = new ModelAndView("layout:home/productList");
        List<Product> products = productService.getAllProducts();
        mav.addObject("products",products);
        return mav;
    }





}
