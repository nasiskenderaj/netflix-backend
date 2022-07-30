package com.example.netflixprojext.controller;

import com.example.netflixprojext.dto.MoviesDTO;
import com.example.netflixprojext.dto.UserDTO;
import com.example.netflixprojext.dto.UserSignInDTO;
import com.example.netflixprojext.entities.Role;
import com.example.netflixprojext.entities.User;
import com.example.netflixprojext.service.MovieService;
import com.example.netflixprojext.service.UserService;
import com.example.netflixprojext.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserServiceImpl userServiceImpl;

    private final MovieService movieService;

    @GetMapping("/usersList")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }


    @PostMapping("/saveUser")
    public ResponseEntity<User>saveUser(@RequestBody User user){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/saveUser").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/saveRole").toUriString());

        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUser form){

        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addMoviestouser/{id}")
    public int addMovieToUser(@RequestHeader("name")String name,@PathVariable("id")Long id){
        movieService.addMovieToUser(name,id);
        return 456567657;

        }
@GetMapping("userMovies/{id}")
public List<MoviesDTO> getUserMOvies(@PathVariable() Long id){
        return userServiceImpl.getUserMovies(id);
}
    public User searchByEmail(@PathVariable("email") String email){
        return userService.getUserByEmail(email);
    }
    @PostMapping("register")
    public User register(@RequestBody() UserDTO userDTO){
       return userServiceImpl.register(userDTO);
    }
    @PostMapping("login")
    public UserDTO login(@RequestBody()UserSignInDTO userSignInDTO){
        return  userServiceImpl.login(userSignInDTO);
    }

}

class RoleToUser{
    private String username;
    private String roleName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
