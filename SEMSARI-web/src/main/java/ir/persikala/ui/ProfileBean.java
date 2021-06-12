package ir.persikala.ui;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Named
@SessionScoped
public class ProfileBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfileBean() {
		// TODO Auto-generated constructor stub
	}
	
	private String email;
	private String pass;
	private String username;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
