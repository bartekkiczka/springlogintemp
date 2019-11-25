package com.negotium.registration.service;

import com.negotium.registration.dao.UserRepository;
import com.negotium.registration.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        CustomUserDetails userDetails = null;
        if(user!=null){
            userDetails = new CustomUserDetails();
            userDetails.setUser(user);
        }else{
            throw new UsernameNotFoundException("User does not exists");
        }
        return userDetails;
    }
}
