package com.example.datastoredemo.service;

import com.example.datastoredemo.model.UserConfig;
import com.example.datastoredemo.repository.UserConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DatastoreUserDetailsService implements UserDetailsService {

    @Autowired
    UserConfigRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserConfig> user = Optional.ofNullable(userRepository.findByUserName(userName));
        user.orElseThrow(()->new UsernameNotFoundException("Not Found: "+userName));
        return user.map(DatastoreUserDetails::new).get();
    }
}
