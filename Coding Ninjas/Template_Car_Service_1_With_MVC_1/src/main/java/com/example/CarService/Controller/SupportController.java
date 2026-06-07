package com.example.CarService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.CarService.service.CarRegistrationService;

@Controller
public class SupportController {

    /**
     1. The method getSupportPage returns string "support" for support page.
     2. Also, the method accepts id of type String & object of type ModelMap as argument.
    **/
	@Autowired
	CarRegistrationService service;

	@RequestMapping("/support")
	public String getSupportPage(@RequestParam("id") String id,
	                             ModelMap map) {

	    map.addAttribute("id", id);

	    return "support";
	}
}
