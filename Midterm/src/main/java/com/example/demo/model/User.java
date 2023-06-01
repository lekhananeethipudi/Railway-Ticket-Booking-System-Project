package com.example.demo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    @Column(nullable = false)
	    private String name;
	    @Column(nullable = false, unique = true)
	    private String email;
	    @Column(nullable = false,length=255)
	    private String password;
	    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(
	            name = "users_roles",
	            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
	            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
	    )
	    private List<Role> roles = new ArrayList<>();

	    public User(String name, String email, String password, List<Role> roles) {
	        this.name = name;
	        this.email = email;
	        this.password = password;
	        this.roles = roles;
	    }
	   
	    
	    
	    
}
