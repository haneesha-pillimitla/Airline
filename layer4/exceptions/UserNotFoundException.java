package com.example.demo.layer4.exceptions;



@SuppressWarnings("serial")
public class UserNotFoundException extends Throwable{
	public UserNotFoundException(String msg) {
		super(msg);
	}
}
