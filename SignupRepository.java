package com.example.demo.layer3;

import java.util.Set;

import com.example.demo.layer2.Signup;

public interface SignupRepository {
	void addSignup(Signup sRef);   //C - add/create
	Signup findSignup(int userid);     //R - find/reading
	Set<Signup> findSignup();     //R - find all/reading all
	void modifySignup(Signup sRef); //U - modify/update
    void removeSignup(int userid);

}
