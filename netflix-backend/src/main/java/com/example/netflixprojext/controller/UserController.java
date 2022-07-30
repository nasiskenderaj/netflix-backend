package com.example.netflixprojext.controller;

import com.example.netflixprojext.dto.MoviesDTO;
import com.example.netflixprojext.dto.UserDTO;
import com.example.netflixprojext.dto.UserSignInDTO;
import com.example.netflixprojext.entities.Role;
import com.example.netflixprojext.entities.User;
import com.example.netflixprojext.errorHandling.NotFoundException;
import com.example.netflixprojext.service.impl.MovieServiceImpl;
import com.example.netflixprojext.service.UserService;
import com.example.netflixprojext.service.impl.TvShowsServiceImpl;
import com.example.netflixprojext.service.impl.UserServiceImpl;
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
    private final UserServiceImpl userServiceImpl;

    private final MovieServiceImpl movieService;

    private final TvShowsServiceImpl tvShowsService;

    @GetMapping("/userList")
    public List<User> getUsers(){
        return userServiceImpl.getUsers();
    }


    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        return userServiceImpl.saveUser(user);
    }

    @PutMapping ("/updateUser")
    public User updateUser(@RequestBody User user){
        return userServiceImpl.saveUser(user);
    }


    @PostMapping("/addMoviestouser/{movieId}")
    public int addMovieToUser(@RequestHeader("userName") String userName,@PathVariable Long movieId){
        movieService.addMovieToUser(userName,movieId);
        return 4565676;

        }

    @PostMapping("/addTvShowtouser/{tvShowid}")
    public int addTvShowToUser(@RequestHeader("userName") String userName,@PathVariable Long tvShowid){
        tvShowsService.addShowToUser(userName,tvShowid);
        return 456567657;

    }
    @GetMapping("userMovies/{id}")
    public List<MoviesDTO> getUserMovies(@PathVariable() Long id){
        return userServiceImpl.getUserMovies(id);
}


    @GetMapping("/email/{email}")
    public User searchByEmail(@PathVariable("email") String email){
        User user = userServiceImpl.getUserByEmail(email);

        if(user==null){
            throw new NotFoundException("User with email "+email+" not found.");
        }
        return user;
    }

    @GetMapping("/name/{name}")
    public User searchByName(@PathVariable("name") String name){
        User user = userServiceImpl.getUserByName(name);

        if(user==null){
            throw new NotFoundException("User with name "+name+" not found.");
        }
        return user;
    }

    @PostMapping("register")
    public User register(@RequestBody() User user){
       return userServiceImpl.register(user);
    }
    @PostMapping("login")

    @GetMapping("login")

    public UserDTO login(@RequestBody()UserSignInDTO userSignInDTO){
        return  userServiceImpl.login(userSignInDTO);
    }

    @DeleteMapping("/deleteUser/{id}")
    public int removeById(@PathVariable Long id) {
        int user = userServiceImpl.removeById(id);

        if(user==0){
            throw new NotFoundException("User with id "+id+" not found.");
        }
        return user;
    }





    //    @PostMapping("/saveUser")
//    public ResponseEntity<User>saveUser(@RequestBody User user){
//        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/saveUser").toUriString());
//        return ResponseEntity.created(uri).body(userService.saveUser(user));
//    }

//
//    @PostMapping("/role/save")
//    public ResponseEntity<Role>saveRole(@RequestBody Role role){
//        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/saveRole").toUriString());
//
//        return ResponseEntity.created(uri).body(userService.saveRole(role));
//    }
//    @PostMapping("/role/addtouser")
//    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUser form){
//
//        userService.addRoleToUser(form.getUsername(), form.getRoleName());
//        return ResponseEntity.ok().build();
//    }

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
