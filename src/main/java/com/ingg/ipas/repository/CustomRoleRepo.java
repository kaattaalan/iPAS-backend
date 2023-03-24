package com.ingg.ipas.repository;

import com.ingg.ipas.models.auth.ERole;
import com.ingg.ipas.models.auth.Role;

import java.util.Optional;

public interface CustomRoleRepo {
    Optional<Role> findByName(ERole name);
}
