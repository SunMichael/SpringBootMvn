package com.sprbt.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/sendhello")
	public String helloFunction() {
		return "hello";
	}
	
	@GetMapping
	public String[] getList() {
		
		String[] ary = new String[3];
		ary[0] = "a";
		ary[1] = "b";
		return  ary;
	}
	
}
