package com.example.demo.layer4;


import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.layer2.Signup;
import com.example.demo.layer3.SignupRepository;
import com.example.demo.layer4.exceptions.UserAlreadyExistsException;
import com.example.demo.layer4.exceptions.UserNotFoundException;


public class SignupServiceImpl implements SignupService{
	
	@Autowired
	SignupRepository signupRepo;
	
	
	@Override
	public void addSignup(Signup sRef) throws UserAlreadyExistsException {
		try {
			signupRepo.addSignup(sRef);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new UserAlreadyExistsException("User already exists");
			
		}
	}

	@Override
	public Signup findSignup(int userid)throws UserNotFoundException {
		
		try {
			return signupRepo.findSignup(userid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new UserNotFoundException("user not found");
		}
	
	}

	
	@Override
	public Set<Signup> findSignup() {
		return signupRepo.findSignup();
	}

	@Override
	public void modifySignup(Signup sRef) throws UserNotFoundException {
		Signup s=signupRepo.findSignup(sRef.getUserid());
		if(s!=null)
		{
			signupRepo.modifySignup(sRef);
		}
		else
		{
			throw new UserNotFoundException("user not found");
		}
	}

	@Override
	public void removeSignup(int userid) throws UserNotFoundException{
		Signup s=signupRepo.findSignup(userid);
		if(s!=null)
		{
			signupRepo.removeSignup(s.getUserid());
		}
		else
		{
			throw new UserNotFoundException("user not found");
		}
	}

}
