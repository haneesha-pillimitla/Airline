package com.example.demo;





import java.time.LocalDate;
import java.util.Set;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.demo.layer2.Signup;
import com.example.demo.layer3.SignupRepository;

@SpringBootTest
class SignupTests {

	
	@Autowired
	SignupRepository SignupRepo;
	
	@Test
	void contextLoads() {
	//Set<Employee2> empSet = empRepo.findEmployeesByDeptno(30);
	
	Signup findurs=SignupRepo.findSignup(1);
	System.out.println(findurs.getUserid());
	System.out.println(findurs.getTitle());
	System.out.println(findurs.getFirstname());
	
	System.out.println(findurs.getLastname());
	System.out.println(findurs.getDateofbirth());
	System.out.println(findurs.getPhoneno());
	System.out.println(findurs.getEmailaddr());
	System.out.println(findurs.getPassword());
	System.out.println(findurs.getConfirmpassword());
	
	
	System.out.println("-----------------");
}
	
	
	@Test
	void addLoads() {
	
	Signup addurs =new Signup();
	//Date date = new SimpleDateFormat("DD-MMM-YY").parse("30-Apr-1998");
	addurs.setTitle("mr");
	addurs.setFirstname("Avinash");
	addurs.setLastname("gangapatnam");
	/*String str="30-Apr-1998";
	Date date1=Date.valueOf(str);
	addurs.setDateofbirth(date1);*/
	//addurs.setDateofbirth(("30-Apr-1998"));
	addurs.setDateofbirth(LocalDate.of(1998,04,30));
	addurs.setPhoneno(9056867548L);
	addurs.setEmailaddr("av.gmail.com");
	addurs.setPassword("avinash");
	addurs.setConfirmpassword("avinash");
	SignupRepo.addSignup(addurs);
	
	System.out.println("----Registered successfully----");
}

	@Test
	void modifyLoads() {
		
		Signup modifyurs=SignupRepo.findSignup(43);
	
	modifyurs.setTitle("mr");
	modifyurs.setFirstname("Avinas");
	modifyurs.setLastname("gangapatnam");
	modifyurs.setDateofbirth(LocalDate.of(1998,04,30));
	modifyurs.setPhoneno(9056867447L);
	modifyurs.setEmailaddr("avi.gmail.com");
	modifyurs.setPassword("avnnash");
	modifyurs.setConfirmpassword("avnnash");
	SignupRepo.modifySignup(modifyurs);
	
	System.out.println("----Registered successfully----");
}
	
	
	@Test
	void removeLoads() {
		SignupRepo.removeSignup(43);
	}
	
	@Test
	void findallLoads() {
		 
		Set<Signup> signupset =SignupRepo.findAllSignup();
		for (Signup s: signupset) {
			System.out.println(s.getUserid());
			System.out.println(s.getTitle());
			System.out.println(s.getFirstname());
			
			System.out.println(s.getLastname());
			System.out.println(s.getDateofbirth());
			System.out.println(s.getPhoneno());
			System.out.println(s.getEmailaddr());
			System.out.println(s.getPassword());
			System.out.println(s.getConfirmpassword());
			
			
			System.out.println("-----------------");
		}
	}
	
	
}

	
	
	
	
