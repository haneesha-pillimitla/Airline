package com.example.demo.layer4;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Signup;
import com.example.demo.layer4.exceptions.UserAlreadyExistsException;
import com.example.demo.layer4.exceptions.UserNotFoundException;

@Service
public interface SignupService {
	String addSignupService(Signup sRef) throws UserAlreadyExistsException;   //C - add/create
	Signup findSignupService(int userid) throws UserNotFoundException;     //R - find/reading
	Set<Signup> findAllSignupService();     //R - find all/reading all
	String modifySignupService(Signup sRef) throws UserNotFoundException; //U - modify/update
	String removeSignupService(int userid) throws UserNotFoundException;
	public String athentication(int user,String pass);
	Signup findSignupbymailService(String email) throws UserNotFoundException;
	Signup findSignupbynumberService(Long phoneno) throws UserNotFoundException;
}
