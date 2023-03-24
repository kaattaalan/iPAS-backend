package com.ingg.ipas.repository.impl;

import com.ingg.ipas.models.auth.ERole;
import com.ingg.ipas.models.auth.Role;
import com.ingg.ipas.repository.CustomRoleRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

@Repository
public class CustomRoleRepositoryImpl implements CustomRoleRepo {
    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Role> findByName(ERole name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Role> query = cb.createQuery(Role.class);
        Root<Role> root = query.from(Role.class);
        query.select(root).where(cb.equal(root.get("name"), name.name()));
        TypedQuery<Role> typedQuery = entityManager.createQuery(query);
        try {
            return Optional.ofNullable(typedQuery.getSingleResult());
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }
}
