package com.negotium.registration.service;

import com.negotium.registration.entity.Role;
import com.negotium.registration.entity.User;
import com.negotium.registration.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        //save(new User(1L,"login", "email", "pass", Set<Role> = new Set<>()));
    }
}
