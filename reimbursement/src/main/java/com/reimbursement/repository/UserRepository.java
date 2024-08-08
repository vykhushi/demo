package com.reimbursement.repository;

import com.reimbursement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
  Optional<User> findByUserEmail(String userEmail);
  }
