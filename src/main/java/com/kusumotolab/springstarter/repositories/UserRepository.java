package com.kusumotolab.springstarter.repositories;

import com.kusumotolab.springstarter.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
