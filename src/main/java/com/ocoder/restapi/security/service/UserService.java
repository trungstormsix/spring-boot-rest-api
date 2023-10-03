package com.ocoder.restapi.security.service;

 
import org.springframework.stereotype.Service;

import com.ocoder.restapi.model.User;
import com.ocoder.restapi.security.dto.AuthenticatedUserDto;
import com.ocoder.restapi.security.dto.RegistrationRequest;
import com.ocoder.restapi.security.dto.RegistrationResponse;

 public interface UserService {
	User findByUsername(String username);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);
}
