package com.pvrg.springmvcdemo.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pvrg.springmvcdemo.model.Account;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AccountController {
	
	@RequestMapping(value = "/createAccount" )
	public String createAccount(@ModelAttribute ("newAccount") Account account) {
				return "createAccount";
	}
	
	@RequestMapping(value="/accountCreated", method=RequestMethod.POST)
	public String accountCreated(@Valid @ModelAttribute ("newAccount") Account account, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			System.out.println("Creation Error");
			return "createAccount";
		} else {
			System.out.println(account);
			return "accountCreated";
		}
	}
	
}
