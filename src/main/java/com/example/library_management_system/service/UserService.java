package com.example.library_management_system.service;

import com.example.library_management_system.dto.UserDTO;
import com.example.library_management_system.entity.User;
import com.example.library_management_system.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    public ModelMapper modelMapper;

    public User addUser(UserDTO userDto) {
        return userRepo.save(modelMapper.map(userDto, User.class));
    }

    public User updateUser(Long userId, UserDTO userDto) {
        return userRepo.save(modelMapper.map(userDto, User.class));
    }

    public void deleteUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepo.delete(user);
    }

    public User getUserDetails(Long userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> listAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}
