package com.ArrancAR.ArrancAR.service;

import com.ArrancAR.ArrancAR.entity.User;

import com.ArrancAR.ArrancAR.entity.Vehicle;
import com.ArrancAR.ArrancAR.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }
    public Optional<User> findUserById(Long idUser) {
        return userRepository.findById(idUser);
    }
    public List<User> listUsers() {
        return userRepository.findAll();
    }
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public void updateUser(User user){
        userRepository.save(user);
    }
}
