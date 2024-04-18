package com.devtech.StorehouseTrackingApp.services.concretes;

import com.devtech.StorehouseTrackingApp.entities.User;
import com.devtech.StorehouseTrackingApp.repositories.UserRepository;
import com.devtech.StorehouseTrackingApp.security.JwtUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailsManager implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(Long id) {
        User user =  userRepository.findById(id).get();
        return JwtUserDetails.create(user);
    }
}
