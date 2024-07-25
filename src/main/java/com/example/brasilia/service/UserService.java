package com.example.brasilia.service;

import com.example.brasilia.entity.User;
import com.example.brasilia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Crear usuario
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Obtener la lista de todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Obtener un usuario por su ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
