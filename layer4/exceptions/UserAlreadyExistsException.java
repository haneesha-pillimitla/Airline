package com.example.demo.layer4.exceptions;



@SuppressWarnings("serial")
public class UserAlreadyExistsException extends Throwable{
	public UserAlreadyExistsException(String msg) {
		super(msg);
	}
}
