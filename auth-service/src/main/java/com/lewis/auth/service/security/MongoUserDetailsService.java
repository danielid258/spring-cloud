package com.lewis.auth.service.security;

import com.lewis.auth.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Daniel on 2018/11/9.
 */
@Service
public class MongoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMongoRepository userMongoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMongoRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
