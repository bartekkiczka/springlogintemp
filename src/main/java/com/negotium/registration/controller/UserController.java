package com.negotium.registration.controller;


import com.negotium.registration.entity.User;
import com.negotium.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
public class UserController {

    UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/all")
    public Iterable<User> findAll(){
        return userService.findAll();
    }


    @PostMapping("/register")
    public User addUser(@RequestBody User user){
        String password = user.getPassword();
        String encryptedPassword = passwordEncoder.encode(password);
        user.setPassword(encryptedPassword);
        return userService.save(user);
    }

    //@PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping("/login")
    public String logged(){
        return "login";
    }

    @RequestMapping("/success")
    public String success(){
        return "logged successfully";
    }

    @RequestMapping("/errorPage")
    public String error(){
        return "error while logging";
    }
}