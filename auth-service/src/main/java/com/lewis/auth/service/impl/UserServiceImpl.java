package com.lewis.auth.service.impl;

import com.lewis.auth.domain.User;
import com.lewis.auth.repository.UserJpaRepository;
import com.lewis.auth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Daniel on 2018/11/9.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public void create(User user) {
        Optional<User> optional = userJpaRepository.findById(user.getUsername());
        optional.ifPresent(it -> {
            throw new IllegalArgumentException("user already exists: " + it.getUsername());
        });
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userJpaRepository.save(user);
        log.info("new user has been created: {}", user.getUsername());
    }
}
