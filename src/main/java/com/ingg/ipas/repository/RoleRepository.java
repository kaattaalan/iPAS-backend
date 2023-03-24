package com.ingg.ipas.repository;

import com.ingg.ipas.models.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String>,CustomRoleRepo {
    Optional<Role> findByName(String name);
}
