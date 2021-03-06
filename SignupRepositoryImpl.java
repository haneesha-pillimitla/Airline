package com.example.demo.layer3;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.layer2.Signup;

@Repository
public class SignupRepositoryImpl implements SignupRepository{
	@PersistenceContext
    EntityManager entityManager;
	
	
	@Transactional
	public void addSignup(Signup sRef) {
		// TODO Auto-generated method stub
		entityManager.persist(sRef);
	}

	@Transactional
	public Signup findSignup(int userid) {
		return entityManager.find(Signup.class,userid);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public Set<Signup> findAllSignup() {
		Set<Signup> signupSet;
		Query query = entityManager.createQuery("from Signup");
		
		signupSet = new HashSet(query.getResultList());
			
		
	return signupSet;
	}

	@Transactional
	public void modifySignup(Signup sRef) {
		// TODO Auto-generated method stub
		entityManager.merge(sRef);
	}

	@Transactional
	public void removeSignup(int userid) {
		// TODO Auto-generated method stub
		Signup sTemp = entityManager.find(Signup.class,userid);
		entityManager.remove(sTemp);
	}
	
	@Transactional
	public Signup findSignupbymail(String email) {
		Signup signup;
		Query query = entityManager.createNativeQuery("select * from signup where emailaddr =" +"'"+ email+"'",Signup.class);
		signup = (Signup) query.getSingleResult();
		return signup;
	}
	
	@Transactional
	public Signup findSignupbynumber(Long phoneno) {
		Signup signup;
		Query query = entityManager.createNativeQuery("select * from signup where phoneno =" +"'"+ phoneno+"'",Signup.class);
		signup = (Signup) query.getSingleResult();
		return signup;
	}

}
