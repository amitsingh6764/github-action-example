package com.nse.github.action.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Gitaction {

	@GetMapping("/getName")
	public String getName() {
		return "Hello Amit!";
	}

}
