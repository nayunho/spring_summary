package com.lec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherController {

	public OtherController() {
		System.out.println("====> OtherController 객체 자동 생성!!");
	}
	
	@GetMapping("/other")
	public String hello(String name) {
		return "Hello!!!!!!!!!!!!!!! " + name;
	}
}
