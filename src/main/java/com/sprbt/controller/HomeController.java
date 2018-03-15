package com.sprbt.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
//	@PathVariable 是url中的参数，RequestParam 是请求中的参数  key要对应
	@RequestMapping(value = "/user/{userid}",method = RequestMethod.GET,consumes = "application/json")
	public String getUserInfo(@PathVariable String userid, @RequestParam String pwd) {
		
		return "welcome," + userid;
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST ,consumes = "application/json")
	public String sendLogin(@RequestParam String name, @RequestParam String password) {
	
		return "userName:" + name + "\n" + "password:" + password;
	}
}
