
package com.furkanzumrut.controller;

import com.furkanzumrut.domain.Product;
import com.furkanzumrut.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * A simple controller rendering an index view and an ajax request.
 *
 * @author cnagel
 */
@Controller
@RequestMapping("/products")
public class ProductListController {

    /**
     * The index end point.
     *
     * @return The view: 'layout:home/index'
     */
    @Autowired
    protected ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getProducts() {
        ModelAndView mav = new ModelAndView("layout:home/productList");
        List<Product> products = productService.getAllProducts();
        mav.addObject("products",products);
        return mav;
    }

    /**
     * The ajax end point. Simply renders the posted parameter.
     *
     * @return The view: 'home/post'
     */



}
