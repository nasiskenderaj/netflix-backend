package com.example.netflixprojext.repository.impl;

import com.example.netflixprojext.entities.User;
import com.example.netflixprojext.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import javax.management.Query;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

//public class UserImpl  {
//
//    private UserRepository userRepository;
//
//    public boolean findByEmail(String email) {
//
//    }
//
//}
