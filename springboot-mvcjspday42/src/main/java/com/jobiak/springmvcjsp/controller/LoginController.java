package com.jobiak.springmvcjsp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jobiak.springmvcjsp.model.LoginBean;
@Controller
public class LoginController {
  Logger logger= LoggerFactory.getLogger(LoginController.class);
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String init(Model model) { 
			// model addAttribute("msg", "Please Enter Your Login Details");
            logger.info("entered get method");
			return "login";
           }
			@RequestMapping(value="log", method=RequestMethod.POST) 
			public String submit(Model model,
            @ModelAttribute("loginBean")LoginBean loginBean) {
			if (loginBean!=null && loginBean.getUserName()!=null
					&loginBean.getPassword()!=null) {
            if (loginBean.getUserName().equals("Okuhara")
               && loginBean.getPassword().equals("Kawasaki")) { 
            	model.addAttribute("msg",loginBean.getUserName());
            	return "success";

			} else {

			model.addAttribute("error", "Invalid Details");
            return "login";
			}
		} else {
             model.addAttribute("error", "Please enter Details"); 
             return "login";
		}
	}

}
