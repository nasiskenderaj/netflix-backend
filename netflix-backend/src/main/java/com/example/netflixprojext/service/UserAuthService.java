package com.example.netflixprojext.service;

import com.example.netflixprojext.dto.UserSignInDTO;
import com.example.netflixprojext.dto.UserSignInResponseDTO;
import com.example.netflixprojext.repository.UserRepository;
//import com.example.netflixprojext.repository.impl.UserImpl;
import org.springframework.stereotype.Service;

//@Service
//public class UserAuthService {
//
//    private UserRepository userRepository;
//    private UserImpl user;
//
//    public UserSignInResponseDTO singIn(UserSignInDTO userSignInDTO){
//        UserSignInResponseDTO userSignInResponseDTO=new UserSignInResponseDTO();
//        if(user.findByEmail(userSignInDTO.getEmail())){
//            userSignInResponseDTO.setDoesUserExist(true);
//        }else{
//            return userSignInResponseDTO;
//        }
//        return null;
//
//    }
//
//}
