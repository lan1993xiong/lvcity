package com.gpnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/exitController")
@Controller
public class ExitController {
    
	@RequestMapping("exitSystem")
	public ModelAndView exitSystem(){
		return new ModelAndView("index");
	}
}
