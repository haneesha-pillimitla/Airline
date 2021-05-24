package com.example.demo.layer5;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.Signup;
import com.example.demo.layer4.SignupService;
import com.example.demo.layer4.exceptions.UserAlreadyExistsException;
import com.example.demo.layer4.exceptions.UserNotFoundException;




@RestController  //REpresentational State Transfer html xml json
public class SignupController {

	@Autowired
	SignupService signupServ;
	
	@GetMapping(path="/getUser/{mysignup}")
	@ResponseBody
	public ResponseEntity<Signup> getSignup(@PathVariable("mysignup") Integer userid) throws UserNotFoundException {
		System.out.println("Signup Controller....Understanding client and talking to service layer...");
		Signup signup;
		
			signup = signupServ.findSignupService(userid);
			if(signup==null)
			{ return ResponseEntity.notFound().build();
			
			}
			else {
				return ResponseEntity.ok(signup);
			}
		
	}
	
	
	@GetMapping(path="/getUsers")
	@ResponseBody
	public Set<Signup> getAllSignupService() {
		System.out.println("Signup Controller....Understanding client and talking to service layer...");
		Set<Signup> signupList = signupServ.findAllSignupService();
		return signupList;
		
	}

	@PostMapping(path="/addUser")
	public String addSignup(@RequestBody Signup signup) {
		System.out.println("Signup Controller....Understanding client and talking to service layer...");
		 String stmsg = null;
		
		 Signup addurs =new Signup();
			//Date date = new SimpleDateFormat("DD-MMM-YY").parse("30-Apr-1998");
			addurs.setTitle(signup.getTitle());
			addurs.setFirstname(signup.getFirstname());
			addurs.setLastname(signup.getLastname());
			addurs.setDateofbirth(signup.getDateofbirth());
			addurs.setPhoneno(signup.getPhoneno());
			addurs.setEmailaddr(signup.getEmailaddr());
			addurs.setPassword(signup.getPassword());
			addurs.setConfirmpassword(signup.getConfirmpassword());
		try {
			stmsg = signupServ.addSignupService(addurs);
		} 
		catch (UserAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		  return stmsg;
		
	}
	
	@PutMapping(path="/modifyUser")
	public  String modifySignup(@RequestBody Signup signup)throws UserNotFoundException {
		System.out.println("signup Controller....Understanding client and talking to service layer...");
		 String stmsg = null;

		try {
			stmsg= signupServ.modifySignupService(signup);
		} 
		catch (UserNotFoundException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		  return stmsg;
		
	}
	
	
	@DeleteMapping(path="/deleteUser") //notworking
	public String removeSignup(@RequestBody Signup signup)throws UserNotFoundException {
		System.out.println("signup Controller....Understanding client and talking to service layer...");
		 String stmsg = null;
		try {
			//int userid = signup.getUserid();
			stmsg = signupServ.removeSignupService(signup.getUserid());
		} 
		catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		  return stmsg;
	}
	
	@GetMapping(path="/loginUser")
	public String login(@RequestBody Signup signup)
	{
		System.out.println("signup Controller....Understanding client and talking to service layer...");
		 String stmsg = null;
		 stmsg = signupServ.athentication(signup.getUserid(),signup.getPassword());
		 return stmsg;
	}
	
	@GetMapping(path="/getUserDetailsByMail")
	public ResponseEntity<Signup> getSignupbyMail(@RequestBody Signup signup) throws UserNotFoundException {
		System.out.println("Signup Controller....Understanding client and talking to service layer...");
	
			signup = signupServ.findSignupbymailService(signup.getEmailaddr());
			if(signup==null)
			{ return ResponseEntity.notFound().build();
			
			}
			else {
				return ResponseEntity.ok(signup);
			}
		
	}
	@GetMapping(path="/getUserDetailsByNumber")
	public ResponseEntity<Signup> getSignubyNumber(@RequestBody Signup signup) throws UserNotFoundException {
		System.out.println("Signup Controller....Understanding client and talking to service layer...");
	
			signup = signupServ.findSignupbynumberService(signup.getPhoneno());
			if(signup==null)
			{ return ResponseEntity.notFound().build();
			
			}
			else {
				return ResponseEntity.ok(signup);
			}
		
	}
	
	@GetMapping(path="/getUser")
	public ResponseEntity<Signup> getUser(@RequestBody Signup signup) throws UserNotFoundException {
		System.out.println("Signup Controller....Understanding client and talking to service layer...");
	
			signup = signupServ.findSignupService(signup.getUserid());
			if(signup==null)
			{ return ResponseEntity.notFound().build();
			
			}
			else {
				return ResponseEntity.ok(signup);
			}
		
	}
	
}
