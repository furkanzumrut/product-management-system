
package com.furkanzumrut.controller;

import com.furkanzumrut.domain.Product;
import com.furkanzumrut.events.JsonResponse;
import com.furkanzumrut.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by furkanzumrut on 6/8/15.
 */
@Controller
public class ProductAddingFormController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value="/productadd",method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("layout:home/productAdd");
        return mav;
    }

    @RequestMapping(value="/ajax/productadd",method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse post(@ModelAttribute(value="product") @Valid Product product, BindingResult result ) {
        JsonResponse res = new JsonResponse();
        ValidationUtils.rejectIfEmpty(result, "name", "Name can not be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(result, "price", "Price not be empty");

        List<Product> productList = new ArrayList<Product>();

        if(!result.hasErrors()){
            productService.saveProduct(product);
            productList.add(product);
            res.setStatus("SUCCESS");
            res.setResult(productList);
        }else{
            res.setStatus("FAIL");
            res.setResult(result.getAllErrors());
        }

        return res;
    }



}
