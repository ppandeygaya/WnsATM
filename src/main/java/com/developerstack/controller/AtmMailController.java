package com.developerstack.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Session;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.developerstack.exception.OutOfCashException;
import com.developerstack.helper.Calculation;
import com.developerstack.model.Refill;
@Controller
public class AtmMailController {
	
	  @RequestMapping(value = "/atm", method = RequestMethod.GET)
	    public String login() {
	    	return "atmwelcome";
	    }
	  
	  @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	  @ExceptionHandler(OutOfCashException.class)
	  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
	    public ModelAndView yes(@RequestParam("withdraw") int withdrawMoney,HttpSession session) throws Exception {
	    	System.out.println("NOw is's Secone page"+withdrawMoney);
	    	int money=0;
	    	if(session.getAttribute("refillMoney")!=null){
	    	   money=(int) session.getAttribute("refillMoney");	
	    	}
	    	
	    	ModelAndView model=new ModelAndView();
	    	if(session.getAttribute("refillMoney")!=null && money>=withdrawMoney){
	    		
	    		System.out.println("Before Wid refilmoney "+session.getAttribute("refillMoney"));
	    		System.out.println("Before Wid refill$20 "+session.getAttribute("refill$20"));
	    		System.out.println("Before Wid refill$50 "+session.getAttribute("refill$50"));
	    		int currency[]=Calculation.withdraw(withdrawMoney,session);
	    		model.addObject("dr20", currency[0]);
	    		model.addObject("dr50", currency[1]);
	    		System.out.println("Before Wid refilmoney "+session.getAttribute("refillMoney"));
	    		System.out.println("Before Wid refill$20 "+session.getAttribute("refill$20"));
	    		System.out.println("Before Wid refill$50 "+session.getAttribute("refill$50"));
	    		int outofCashflag=(int) session.getAttribute("outofCashflag");
	    		if(outofCashflag==1){
	    			model.addObject("error", "Running out of cash");
	    			model.setViewName("atmwelcome");
	    		}else{
	    		model.setViewName("sucess");
	    		}
	    	}else{
	    		System.out.println("else part"+session.getAttribute("refillMoney"));
	    		
	    		model.addObject("error", "Running out of cash");
	        	model.setViewName("atmwelcome");
	        	return model;
	    	}
	    	
	    	return model;
	    }
	  
	  
	   
}
