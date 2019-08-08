package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.FirstService;
import com.example.demo.service.FirstServiceImpl;

@RestController
public class FirstController {
	
	@Autowired
	FirstService firstService;
	
	@RequestMapping(value="/helloString", method=RequestMethod.POST)
	public String[] helloString(@RequestBody String inputStr) {	
				
		return firstService.processString(inputStr); 	
		
	}
}
