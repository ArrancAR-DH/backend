package com.ArrancAR.ArrancAR.repository;

import com.ArrancAR.ArrancAR.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);
}
