package com.pvrg.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

	@RequestMapping(value="/demoParams", params="from")
	public String demoParams(Model model){
		model.addAttribute("message", "My message");
		return "demoPage";
	}
	
	@RequestMapping(value="/demoHeader", headers="API-KEY=123456")
	public String demoHeader(Model model){
		model.addAttribute("message", "My message");
		return "demoPage";
	}
	
	@RequestMapping(value="/demoRequestParam")
	public String demoRequestParam(@RequestParam("from") String from, Model model){
		model.addAttribute("message", "My message");
		model.addAttribute("from", from);
		return "demoPage";
	}
}
