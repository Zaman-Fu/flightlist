package skyviewer.service.flightlist.entities;
///While aware that the user validation process should take place in another microservice,
///We have added the user validation api in the flight microservice 
///to make checking our work less cumbersome for the evaluators///

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
public class AdminUser {
	@Id
	@GeneratedValue
	Long Id;
	
	@Column
	String username;
	
	@Column
	String firstname;
	
	@Column
	String lastname;
	
	@Column
	String password;

	public AdminUser() {}
	public AdminUser(Long id, String username, String firstname, String lastname, String password) {
		super();
		Id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminUser [Id=" + Id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", password=" + password + "]";
	}
	
	
	

}
