package com.Club_Futbol.app.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ControllerInicio {
	
	@GetMapping("/")
	public String verPaginaInicio(){
		return "index";
	}
	
}