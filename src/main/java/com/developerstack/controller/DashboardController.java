package com.developerstack.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.developerstack.model.Refill;

@Controller
@SessionAttributes("refil")
public class DashboardController {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() {
    	System.out.println("DashBord Comming");
    	ModelAndView model = new ModelAndView();
    	model.setViewName("dashboard");
    	return model;
    }
    
    @RequestMapping(value = "/refill", method = RequestMethod.POST)
    //@ModelAttribute("refil")
    public ModelAndView refillMoney(@RequestParam("refillMoney") int refillMoney,@RequestParam("refill$20") int refill$20,@RequestParam("refill$50") int refill$50,HttpSession session) {
    	
    	ModelAndView model = new ModelAndView();
    	if(refillMoney== ((20*refill$20)+(50*refill$50))){
    		System.out.println("Refilling Comming"+refillMoney);
        	System.out.println("Refilling Comming"+refill$20);
        	System.out.println("Refilling Comming"+refill$50);
        	session.setAttribute("refill$20", refill$20);
        	session.setAttribute("refill$50", refill$50);
        	session.setAttribute("refillMoney", refillMoney);
    		model.setViewName("atmwelcome");
    	}else{
    		model.addObject("error", "Please Enter The Valid Amount");
    		model.setViewName("dashboard");
    	}
    	
    	return model;
    }
}
