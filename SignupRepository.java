package com.example.demo.layer3;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Signup;
@Repository
public interface SignupRepository {
	void addSignup(Signup sRef);   //C - add/create
	Signup findSignup(int userid);     //R - find/reading
	Set<Signup> findAllSignup();     //R - find all/reading all
	void modifySignup(Signup sRef); //U - modify/update
	void removeSignup(int userid);
	
	public Signup findSignupbymail(String email);
	public Signup findSignupbynumber(Long phoneno);

}
