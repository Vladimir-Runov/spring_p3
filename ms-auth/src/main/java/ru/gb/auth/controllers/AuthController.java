package ru.gb.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;

import ru.gb.auth.dtos.AuthRequestDto;
import ru.gb.auth.dtos.AuthResponseDto;
import ru.gb.auth.dtos.SignUpRequestDto;
import ru.gb.auth.entities.User;
import ru.gb.auth.services.UserService;
import ru.gb.core.models.UserInfo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private ru.gb.core.interfaces.ITokenService iTokenService;

    @Autowired
    private ru.gb.core.repositories.RedisRepository redisRepository;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody SignUpRequestDto signUpRequest) {
        User user = new User();
        user.setPassword(signUpRequest.getPassword());
        user.setEmail(signUpRequest.getEmail());
        userService.saveUser(user);
    }

    @GetMapping("/logout")
    public Boolean logout(@RequestHeader("Authorization") String token) {
        redisRepository.saveToken(token);
        return true;
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody AuthRequestDto request) {
        User user = userService.findByLoginAndPassword(request.getEmail(), request.getPassword());
        List<String> roles = new ArrayList<>();

        user.getRole().forEach(role -> roles.add(role.getName()));

        UserInfo userInfo = UserInfo.builder()
                .userId(user.getId())
                .userEmail(user.getEmail())
                .role(roles)
                .build();

        String token = iTokenService.generateToken(userInfo);
        return new AuthResponseDto(token);
    }
}
