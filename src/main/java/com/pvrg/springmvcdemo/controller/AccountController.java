package com.pvrg.springmvcdemo.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pvrg.springmvcdemo.model.Account;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("newAccount")
public class AccountController {
	
	@RequestMapping(value = "/createAccount" )
	public String createAccount(@ModelAttribute ("newAccount") Account account) {
		System.out.println("NewAccount");
				return "createAccount";
	}
	
	@RequestMapping(value="/accountCreated", method=RequestMethod.POST)
	public String accountCreated(@Valid @ModelAttribute ("newAccount") Account account, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			System.out.println("Creation Error");
			return "createAccount";
		} else {
			System.out.println(account);
			return "redirect:accountConf";
		}
	}
	
	@RequestMapping(value="/accountConf")
	public String accountConf(@ModelAttribute ("newAccount") Account account){
		System.out.println("accountConf");
		System.out.println(account);
		return "accountCreated";
	}
	
	@ModelAttribute
	public void addAccountToModel(Model model){
		if(!model.containsAttribute("newAccount")){
			Account a =new Account();
			model.addAttribute("newAccount",a);
		}
	}
	
	//Requires <url>?location=<value> to be added to address bar
//	@ModelAttribute
//	public void addExtraDetails(@RequestParam ("location") String location, Model model){
//		model.addAttribute("location", location);
//	}
	
}
