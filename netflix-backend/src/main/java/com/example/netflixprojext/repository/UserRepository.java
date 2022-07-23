package com.example.netflixprojext.repository;

import com.example.netflixprojext.dto.UserDTO;
import com.example.netflixprojext.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);
    User findByName(String name);


}
