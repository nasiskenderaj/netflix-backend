package com.example.netflixprojext.service;

import com.example.netflixprojext.dto.UserDTO;
import com.example.netflixprojext.entities.Role;
import com.example.netflixprojext.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String email,String roleName);
    User getUserByEmail(String email);
    List<User> getUsers();
    int removeById(Long id);
}
