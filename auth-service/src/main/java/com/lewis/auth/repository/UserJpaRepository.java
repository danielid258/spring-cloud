package com.lewis.auth.repository;

import com.lewis.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Daniel on 2018/11/9.
 * <p>
 * jdbc repository
 */
@Repository
public interface UserJpaRepository extends JpaRepository<User, String> {
}
