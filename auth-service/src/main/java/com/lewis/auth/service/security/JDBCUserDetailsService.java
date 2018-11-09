package com.lewis.auth.service.security;

import com.lewis.auth.repository.UserJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Daniel on 2018/11/9.
 */
@Slf4j
@Service
public class JDBCUserDetailsService implements UserDetailsService {
    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userJpaRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
