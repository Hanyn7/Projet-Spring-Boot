package com.hanin.parfums.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hanin.parfums.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}