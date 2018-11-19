package patientlogin;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

//import java.util.Date;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Patient {
	private int id;
	@NotNull(message="null usernames not allowed")
	private String username;
	@NotNull(message="null passwords not allowed")
	@Size(min = 5, max= 8, message="must be between 5 and 8 char")
	  private String password;
	  private String firstname;
	  private String lastname;
	  
	  @Email(message="not a valid email")
	  private String email;
	  private String address;
	  private int phone;
	  private String ssn ;
	// @NotEmpty(message="dob cannot be empty")
	  @Past(message="must be in the past")
	 private Date dob;
	  
	  public int getId() {
		  
		  return id;
	  }
	  
	  public void setId(int id) {
		  
		  this.id = id;
	  }
	  public String getSsn() {
		  return ssn;
		  
	  }
	  public void setSsn(String ssn) {
		  
		  this.ssn = ssn;
	  }
	  public String getUsername() {
	  return username;
	  }
	  public void setUsername(String username) {
	  this.username = username;
	  }
	  public String getPassword() {
	  return password;
	  }
	  public void setPassword(String password) {
	  this.password = password;
	  }
	  public String getFirstname() {
	  return firstname;
	  }
	  public void setFirstname(String firstname) {
	  this.firstname = firstname;
	  }
	  public String getLastname() {
	  return lastname;
	  }
	  public void setLastname(String lastname) {
	  this.lastname = lastname;
	  }
	  public String getEmail() {
	  return email;
	  }
	  public void setEmail(String email) {
	  this.email = email;
	  }
	  public String getAddress() {
	  return address;
	  }
	  public void setAddress(String address) {
	  this.address = address;
	  }
	  public int getPhone() {
	  return phone;
	  }
	  public void setPhone(int phone) {
	  this.phone = phone;
	  }
	  
	  public Date getDob( ) {
		  return dob;
		  
	  }
	  public void setDob(Date dob) {
		  this.dob =dob;
		  
	  }
}
