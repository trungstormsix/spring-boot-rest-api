package com.ocoder.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ocoder.restapi.repository.UserRepository;

@RestController
public class HelloCotroller {

	 @Autowired
	    private UserRepository userRepo;
	     
	    @GetMapping("")
	    public String viewHomePage() {
	        return "index";
	    }
	    
	@RequestMapping("/")
	public String test() {
		return "sdfsd";
	}
	@RequestMapping("/home")
	public String home() {
		return "Home Page";
	}
}
