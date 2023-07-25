package com.example.tp07072023gestionposts.service;

import com.example.tp07072023gestionposts.entity.User;
import com.example.tp07072023gestionposts.exception.NotFoundException;
import com.example.tp07072023gestionposts.repository.UserRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Utilisateur non trouvé"));
    }

    public User updateUser(Long userId, User user) {
        if (!userRepository.existsById(userId)) {
            throw new NotFoundException("Utilisateur non trouvé");
        }
        user.setId(userId);
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new NotFoundException("Utilisateur non trouvé");
        }
        userRepository.deleteById(userId);
    }
}
