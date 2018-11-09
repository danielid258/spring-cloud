package com.lewis.auth.repository;

import com.lewis.auth.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Daniel on 2018/11/9.
 */
@Repository
public interface UserMongoRepository extends CrudRepository<User, String> {

}
