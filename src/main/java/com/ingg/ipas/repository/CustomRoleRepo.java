package com.ingg.ipas.repository;

import com.ingg.ipas.models.ERole;
import com.ingg.ipas.models.Role;

import java.util.Optional;

public interface CustomRoleRepo {
    Optional<Role> findByName(ERole name);
}
