package com.ocoder.restapi.security.dto;

import com.ocoder.restapi.model.UserRole;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticatedUserDto {

	private String name;

	private String username;

	private String password;

	private UserRole userRole;

}