
package com.furkanzumrut.controller;

import com.furkanzumrut.domain.Product;
import com.furkanzumrut.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * A simple controller rendering an index view and an ajax request.
 *
 * @author cnagel
 */
@Controller
@RequestMapping("/productadd")
public class ProductAddingFormController {

    @Autowired
    private ProductService productService;
    /**
     * The index end point.
     *
     * @return The view: 'layout:home/index'
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("layout:home/productAdd");
        return mav;
    }

    /**
     * The ajax end point. Simply renders the posted parameter.
     *
     * @return The view: 'home/post'
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView post(@RequestParam("name") String name, @RequestParam("price") String price) {
        ModelAndView mav = new ModelAndView("home/post");
        Product p = new Product();
        p.setName(name);
        p.setPrice(Integer.parseInt(price));
        productService.saveProduct(p);
        mav.addObject("response", "Successfully Added.");
        return mav;
    }



}
