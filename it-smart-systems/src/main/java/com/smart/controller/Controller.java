package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.service.MergeServiceImpl;

@RestController
public class Controller {
	
	@Autowired
	MergeServiceImpl mergeServiceImpl;
	
	@GetMapping("/merge-input")
	public String mergeTables() {
		return mergeServiceImpl.mergeTables();
	}
	
}
