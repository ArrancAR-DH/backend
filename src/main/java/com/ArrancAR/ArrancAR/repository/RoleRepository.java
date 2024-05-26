package com.ArrancAR.ArrancAR.repository;

import com.ArrancAR.ArrancAR.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
