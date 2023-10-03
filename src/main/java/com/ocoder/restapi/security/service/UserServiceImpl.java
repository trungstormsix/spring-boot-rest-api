package com.ocoder.restapi.security.service;

 
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ocoder.restapi.mapper.UserMapper;
import com.ocoder.restapi.model.User;
import com.ocoder.restapi.model.UserRole;
import com.ocoder.restapi.repository.UserRepository;
import com.ocoder.restapi.security.dto.AuthenticatedUserDto;
import com.ocoder.restapi.security.dto.RegistrationRequest;
import com.ocoder.restapi.security.dto.RegistrationResponse;
import com.ocoder.restapi.util.GeneralMessageAccessor;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private static final String REGISTRATION_SUCCESSFUL = "registration_successful";

	@Autowired
	private   UserRepository userRepository;
	@Autowired
	private   BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private   UserValidationService userValidationService;
	@Autowired
	private   GeneralMessageAccessor generalMessageAccessor;

	@Override
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	@Override
	public RegistrationResponse registration(RegistrationRequest registrationRequest) {

		userValidationService.validateUser(registrationRequest);

		final User user = UserMapper.INSTANCE.convertToUser(registrationRequest);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserRole(UserRole.USER);

		userRepository.save(user);

		final String username = registrationRequest.getUsername();
		log.debug(username);
		final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL, username);

		log.info("{} registered successfully!", username);

		return new RegistrationResponse(registrationSuccessMessage);
	}

	@Override
	public AuthenticatedUserDto findAuthenticatedUserByUsername(String username) {

		final User user = findByUsername(username);

		return UserMapper.INSTANCE.convertToAuthenticatedUserDto(user);
	}
}