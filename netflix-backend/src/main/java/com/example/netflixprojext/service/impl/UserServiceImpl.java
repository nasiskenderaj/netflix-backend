package com.example.netflixprojext.service.impl;

import com.example.netflixprojext.dao.impl.MoviesDAOImpl;
import com.example.netflixprojext.dao.impl.UserDAOimpl;
import com.example.netflixprojext.dto.MoviesDTO;
import com.example.netflixprojext.dto.UserDTO;
import com.example.netflixprojext.dto.UserSignInDTO;
import com.example.netflixprojext.entities.Role;
import com.example.netflixprojext.entities.User;
import com.example.netflixprojext.repository.RoleRepository;
import com.example.netflixprojext.repository.UserRepository;
import com.example.netflixprojext.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepo;

    private final MoviesDAOImpl moviesDAO;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
    public User register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user) ;
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        User user=userRepo.findByEmail(email);
        Role role=roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);
    }
    public UserDTO login(UserSignInDTO userSignInDTO){
        User byName = userRepo.findByName(userSignInDTO.getName());
        if (passwordEncoder.matches(userSignInDTO.getPassword(), byName.getPassword())){
            return UserDAOimpl.mapToDTO(byName);
        }
return null;
    }


    @Override
    public User getUserByEmail(String email) {
        User user = userRepo.findByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException("Username not found");
        }else{
            return user;
        }
    }

    @Override
    public User getUserByName(String name) {
        User user = userRepo.findByName(name);
        if(user==null){
            throw new UsernameNotFoundException("Username not found");
        }else{
            return user;
        }
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public int removeById(Long id) {
        Optional<User> optional = userRepo.findById(id);
        if(optional.isPresent()){
            userRepo.deleteById(id);
            return 1;
        }
        return 0;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user=userRepo.findByName(name);
        if(user==null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<SimpleGrantedAuthority>authorities=new ArrayList<>();
        user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getRoleName()));});
        return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),authorities);
    }
    public List<MoviesDTO> getUserMovies(Long id){
        return moviesDAO.getUserMovieList(id);
    }
}
