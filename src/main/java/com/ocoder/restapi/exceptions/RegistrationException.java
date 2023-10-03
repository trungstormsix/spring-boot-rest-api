package com.ocoder.restapi.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegistrationException extends RuntimeException {

	private   String errorMessage;
	
	public  RegistrationException(String errString){
		this.errorMessage = errString;
	}
}
