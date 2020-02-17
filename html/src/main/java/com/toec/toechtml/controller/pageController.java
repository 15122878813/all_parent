package com.toec.toechtml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class pageController {
	
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "index";
	}
	@RequestMapping("/{ui}")
	public String doModuleUI(@PathVariable String ui) {
		return ui;
	}
	
	@RequestMapping("/doLoginUI")
	public String doLoginUI(){
		return "login";
	}
	
	@RequestMapping("/doZhuceUI")
	public String doZhuceUI() {
		return "zhuce";
	}
}