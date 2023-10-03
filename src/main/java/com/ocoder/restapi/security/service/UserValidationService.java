package com.ocoder.restapi.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocoder.restapi.exceptions.RegistrationException;
import com.ocoder.restapi.repository.UserRepository;
import com.ocoder.restapi.security.dto.RegistrationRequest;
import com.ocoder.restapi.util.ExceptionMessageAccessor;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserValidationService {

	private static final String EMAIL_ALREADY_EXISTS = "email_already_exists";

	private static final String USERNAME_ALREADY_EXISTS = "username_already_exists";
	@Autowired
	private   UserRepository userRepository;
	@Autowired
	private   ExceptionMessageAccessor exceptionMessageAccessor;

	public void validateUser(RegistrationRequest registrationRequest) {

		final String email = registrationRequest.getEmail();
		final String username = registrationRequest.getUsername();

		checkEmail(email);
		checkUsername(username);
	}

	private void checkUsername(String username) {

		final boolean existsByUsername = userRepository.existsByUsername(username);

		if (existsByUsername) {

			log.warn("{} is already being used!", username);

			final String existsUsername = exceptionMessageAccessor.getMessage(null, USERNAME_ALREADY_EXISTS);
			log.warn("{} is already being used!", username);

			throw new RegistrationException(existsUsername);
		}

	}

	private void checkEmail(String email) {

		final boolean existsByEmail = userRepository.existsByEmail(email);

		if (existsByEmail) {

			log.warn("{} is already being used!", email);

			final String existsEmail ="dfdf " + exceptionMessageAccessor.getMessage(null, EMAIL_ALREADY_EXISTS);
			log.warn("{} is already being used! " + existsEmail, email);

			throw new RegistrationException(existsEmail);
		}
	}

}
