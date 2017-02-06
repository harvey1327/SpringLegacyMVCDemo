package com.pvrg.springmvcdemo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieDemoController {
	
	@RequestMapping(value="/addCookie")
	public String addCookie(HttpServletResponse response){
		response.addCookie(new Cookie("myCookieName","CookieHasBeenAdded"));
		System.out.println("Cookie has been added");
		return "demoPage";
	}
	
	@RequestMapping(value="/getCookie")
	public String getCookie(@CookieValue("myCookieName") String myCookie){
		System.out.println("Cookie: "+myCookie);
		return "demoPage";
	}
}
