package com.wiley.assessment.main.authentication.services;

import com.wiley.assessment.main.models.User;
import com.wiley.assessment.main.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    private UserRepository userRepository;

    public UserInfoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.getUserByUsername(userName);
        return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), new ArrayList<>());
    }
}
