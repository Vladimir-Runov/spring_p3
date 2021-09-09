package ru.gb.auth.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ru.gb.auth.entities.Role;
import ru.gb.auth.entities.User;
import ru.gb.auth.repositories.RoleRepository;
import ru.gb.auth.repositories.UserRepository;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {

   // @Autowired
    private UserRepository userRepository;

    //@Autowired
    private RoleRepository roleRepository;

    //@Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        Role role = roleRepository.findByName("ROLE_USER");
        user.setRole(Collections.singletonList(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByLoginAndPassword(String email, String password) {
        User userEntity = findByEmail(email);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }
}
