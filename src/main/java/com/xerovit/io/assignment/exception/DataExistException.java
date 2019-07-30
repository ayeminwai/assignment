package com.xerovit.io.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class DataExistException extends RuntimeException {

	private static final long serialVersionUID = 8882223323100210506L;

	public static final String PHONE_NUMBER_EXIST = "Phone number already exist.";
	public static final String EMAIL_EXIST = "Email already exist";
	public static final String USER_EXIST = "User already exist.";

	public DataExistException(String msg) {
		super(msg);
	}

}
