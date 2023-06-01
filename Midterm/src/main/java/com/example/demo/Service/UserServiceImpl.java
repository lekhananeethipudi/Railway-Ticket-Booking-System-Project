package com.example.demo.Service;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.TbConstants;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.model.UserDto;

@Service
public class UserServiceImpl  implements UserService{
	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private RoleRepository roleRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Override
	    public void saveUser(UserDto userDto) {
	        Role role = roleRepository.findByName(TbConstants.Roles.USER);

	        if (role == null)
	            role = roleRepository.save(new Role(TbConstants.Roles.USER));

	        User user = new User(userDto.getName(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()),
	                Arrays.asList(role));
	        userRepository.save(user);
	    }

	    @Override
	    public User findUserByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }
	

}
