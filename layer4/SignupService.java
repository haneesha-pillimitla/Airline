package com.example.demo.layer4;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Signup;
import com.example.demo.layer4.exceptions.UserAlreadyExistsException;
import com.example.demo.layer4.exceptions.UserNotFoundException;

@Service
public interface SignupService {
	void addSignupService(Signup sRef) throws UserAlreadyExistsException;   //C - add/create
	Signup findSignupService(int userid) throws UserNotFoundException;     //R - find/reading
	Set<Signup> findAllSignupService();     //R - find all/reading all
	void modifySignupService(Signup sRef) throws UserNotFoundException; //U - modify/update
	void removeSignupService(int userid) throws UserNotFoundException;

}
