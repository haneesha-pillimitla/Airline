package com.example.demo.layer2;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the SIGNUP database table.
 * 
 */
@Entity
@Table(name="SIGNUP")
@NamedQuery(name="Signup.findAll", query="SELECT s FROM Signup s")
public class Signup  {
	

	@Id
	@GeneratedValue
	private int userid;

	private String confirmpassword;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateofbirth;

	private String emailaddr;

	private String firstname;

	private String lastname;

	private String password;

	private Long phoneno;

	private String title;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="signup", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Reservation> reservations;

	public Signup() {
		super();
		System.out.println("Signup contr()......");
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getConfirmpassword() {
		return this.confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public Date getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getEmailaddr() {
		return this.emailaddr;
	}

	public void setEmailaddr(String emailaddr) {
		this.emailaddr = emailaddr;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneno() {
		return this.phoneno;
	}

	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setSignup(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setSignup(null);

		return reservation;
	}

}