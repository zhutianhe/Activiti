package com.zth.main.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("prototype")
@RequestMapping("/main")
public class MainController{
	
	@RequestMapping(value = "/index.html")
	public ModelAndView mainPage(HttpSession session, HttpServletRequest request) throws Exception{
		System.out.println("========");
		ModelAndView mav = new ModelAndView("/index");
		return mav;
	}
}
