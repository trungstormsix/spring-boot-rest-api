package com.ocoder.restapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ocoder.restapi.exceptions.RegistrationException;
import com.ocoder.restapi.security.dto.RegistrationRequest;
import com.ocoder.restapi.security.dto.RegistrationResponse;
import com.ocoder.restapi.security.service.UserService;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {
 
	@Autowired
	private   UserService userService;

	@PostMapping
	public ResponseEntity<RegistrationResponse> registrationRequest(@Valid @RequestBody RegistrationRequest registrationRequest) {
		
		try {
		final RegistrationResponse registrationResponse = userService.registration(registrationRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);

		}catch (RegistrationException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new RegistrationResponse(e.getErrorMessage()));

		} 
	}
	
//	@GetMapping("/t")
//	public ResponseEntity<RegistrationResponse> registrationRequestGet(@RequestBody RegistrationRequest registrationRequest) {
//
//		final RegistrationResponse registrationResponse = userService.registration(registrationRequest);
//
//		return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
//	}
	
	@GetMapping("/t")
	public @ResponseBody ResponseEntity<RegistrationResponse> registrationRequestGet(@RequestParam("email") String email) {
		RegistrationRequest req = new RegistrationRequest();
		req.setName("e");
		req.setEmail("email");
		req.setPassword("a");
		req.setUsername("sd");
		try {
		final RegistrationResponse registrationResponse = userService.registration(req);
		return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
		}catch (RegistrationException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new RegistrationResponse(e.getErrorMessage()));

		} 
	 
//		final RegistrationResponse registrationResponse = userService.registration(registrationRequest);
//
//		return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
	}


}