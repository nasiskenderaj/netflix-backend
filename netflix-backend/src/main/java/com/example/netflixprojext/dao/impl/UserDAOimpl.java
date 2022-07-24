package com.example.netflixprojext.dao.impl;

import com.example.netflixprojext.dto.UserDTO;
import com.example.netflixprojext.entities.User;
import com.example.netflixprojext.repository.RoleRepository;
import com.example.netflixprojext.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserDAOimpl {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public List<UserDTO>getAll(){
        return userRepository.findAll().stream().map(UserDAOimpl::mapToDTO).collect(Collectors.toList());
    }

    public User add(UserDTO dto){
        return userRepository.save(mapToEntity(dto));
    }

    public UserDTO getById(Long id){
        Optional<User> optional = userRepository.findById(id);
        return optional.map(UserDAOimpl::mapToDTO).orElse(null);
    }

    public int removeById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()){
            userRepository.deleteById(id);
            return 1;
        }
        return 0;
    }





    public static User mapToEntity(UserDTO userDTO){
        User user=new User();

        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setAge(user.getAge());
        user.setEmail(user.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setTvShowsList(userDTO.getTvShowsList());
        user.setMovieList(userDTO.getMovieList());
        user.setRoles(userDTO.getRoles());

        return user;
    }

    public static UserDTO mapToDTO(User user){
        if(user==null){
            return null;
        }

        UserDTO userDTO=new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setAge(user.getAge());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setTvShowsList(user.getTvShowsList());
        userDTO.setMovieList(user.getMovieList());
        userDTO.setRoles(user.getRoles());
        return userDTO;
    }

}
