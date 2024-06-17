package com.ArrancAR.ArrancAR.repository;

import com.ArrancAR.ArrancAR.entity.Booking;
import com.ArrancAR.ArrancAR.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);
    Optional<User> findByUserName(String userName);
    Boolean existsByEmail(String email);
    Optional<User> findByUserNameOrEmail(String userName,String email);
    Boolean existsByUserName(String userName);
}
