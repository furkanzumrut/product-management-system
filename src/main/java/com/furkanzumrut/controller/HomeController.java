
package com.furkanzumrut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by furkanzumrut on 6/8/15.
 */
@Controller
@RequestMapping("/")
public class HomeController {


	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("layout:home/index");
		return mav;
	}




}
