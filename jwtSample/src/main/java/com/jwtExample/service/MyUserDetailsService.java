package com.jwtExample.service;

import com.jwtExample.entities.User;
import com.jwtExample.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepo.findByUsername(username);
       if(user == null){
           System.out.println("user not found with given username!");
           throw new UsernameNotFoundException("user not found with given username!!");
       }
       return (UserDetails) user;
    }
}
