package com.as.powerskill.repository;

import com.as.powerskill.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Abdurrahman Samgar
 */
@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> findByUniqueUserName(String uniqueUserName);
}
