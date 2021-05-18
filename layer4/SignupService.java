package com.example.demo.layer4;

import java.util.Set;

import com.example.demo.layer2.Signup;
import com.example.demo.layer4.exceptions.UserAlreadyExistsException;
import com.example.demo.layer4.exceptions.UserNotFoundException;

public interface SignupService {
	void addSignup(Signup sRef) throws UserAlreadyExistsException;   //C - add/create
	Signup findSignup(int userid) throws UserNotFoundException;     //R - find/reading
	Set<Signup> findSignup();     //R - find all/reading all
	void modifySignup(Signup sRef) throws UserNotFoundException; //U - modify/update
	void removeSignup(int userid) throws UserNotFoundException;

}
