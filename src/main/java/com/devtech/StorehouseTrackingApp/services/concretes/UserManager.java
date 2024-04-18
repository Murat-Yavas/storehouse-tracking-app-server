package com.devtech.StorehouseTrackingApp.services.concretes;

import com.devtech.StorehouseTrackingApp.entities.User;
import com.devtech.StorehouseTrackingApp.repositories.UserRepository;
import com.devtech.StorehouseTrackingApp.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User getOneUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User updateOneUser(Long userId, User newUser) {
        Optional<User> userToUpdate = userRepository.findById(userId);

        if(userToUpdate.isPresent()) {
            User foundUser = userToUpdate.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        } else
            return null;
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
