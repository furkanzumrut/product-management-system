
package com.furkanzumrut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * A simple controller rendering an index view and an ajax request.
 * 
 * @author cnagel
 */
@Controller
@RequestMapping("/")
public class HomeController {

	/**
	 * The index end point.
	 * 
	 * @return The view: 'layout:home/index'
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("layout:home/index");
		return mav;
	}




}
