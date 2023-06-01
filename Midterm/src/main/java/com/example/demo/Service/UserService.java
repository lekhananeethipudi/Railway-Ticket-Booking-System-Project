package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.User;
import com.example.demo.model.UserDto;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
}