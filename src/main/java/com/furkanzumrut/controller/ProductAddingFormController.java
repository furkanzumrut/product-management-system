
package com.furkanzumrut.controller;

import com.furkanzumrut.domain.Product;
import com.furkanzumrut.events.JsonResponse;
import com.furkanzumrut.service.IProductService;
import com.furkanzumrut.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.Date;
import javax.validation.Valid;
import java.util.ArrayList;

import java.util.List;

/**
 * Created by furkanzumrut on 6/8/15.
 */
@Controller
public class ProductAddingFormController {

    @Autowired
    private IProductService productService;

    @RequestMapping(value="/productadd",method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("layout:home/productAdd");
        return mav;
    }

    @RequestMapping(value="/ajax/productadd",method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse post(@ModelAttribute(value="product") @Valid Product product, BindingResult result ) {
        JsonResponse res = new JsonResponse();

        List<Product> productList = new ArrayList<Product>();

        if(!result.hasErrors()){

            product.setDate(new Date());
            product.setUserId(1);
            product.setUserName("furkanzumrut");
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
