package com.example.demo.model;





import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",length =45)
	private int id;
	
	@NotBlank(message ="Name field is required")
	@Size(min=4,max=30, message="min 4 and max 20 characters are allowed")
	@Column(name="full_name",length =50)
	private String fullname;
	
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	@NotBlank(message="Email field is required")
	@Column(name="email",length =255,unique=true)
	@NaturalId(mutable=true)
	private String email;
	
	@Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]{8,}$", 
	        message = "Password must be at least 8 characters long and "
	        		+ "contain at least one uppercase letter, "
	        		+ "one lowercase letter, "
	        		+ "one digit, "
	        		+ "and one special character.")
		@Column(name="password",length =255)
		@NotBlank(message="Password field is required")
	private String password;
	
	@Column(name="role",length =50)
	private String role;

	
	public Admin(int id,
			@NotBlank(message = "Name field is required") @Size(min = 4, max = 30, message = "min 4 and max 20 characters are allowed") String fullname,
			@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$") @NotBlank(message = "Email field is required") String email,
			@Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]{8,}$", message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.") @NotBlank(message = "Password field is required") String password,
			String role) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public Admin(
			@NotBlank(message = "Name field is required") @Size(min = 4, max = 30, message = "min 4 and max 20 characters are allowed") String fullname,
			@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$") @NotBlank(message = "Email field is required") String email,
			@Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]{8,}$", message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.") @NotBlank(message = "Password field is required") String password,
			String role) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", fullname=" + fullname + ", email=" + email + ", password=" + password + ", role="
				+ role + "]";
	}
}