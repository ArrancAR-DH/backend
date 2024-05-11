package com.ArrancAR.ArrancAR.repository;

import com.ArrancAR.ArrancAR.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
