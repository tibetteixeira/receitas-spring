package io.github.tibetteixeira.api.v1.domain.repository.impl;

import javax.persistence.EntityManager;

public class UsuarioRepositoryImpl {

    private EntityManager entityManager;

    public UsuarioRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
