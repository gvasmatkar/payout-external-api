package com.paymaya.payout.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern.Flag;

public class User {

    public User(String email, String password) {
        this.email = email;
        this.password = password;
       
    }

    public User() {};
    @NotEmpty(message = "name is required.")
//	@NotNull(message = "name is required.")
	@Size(min = 2, max = 50, message = "The length of full name must be between 2 and 100 characters.")
	@Email
    private String email;
    private String password;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
   
}
