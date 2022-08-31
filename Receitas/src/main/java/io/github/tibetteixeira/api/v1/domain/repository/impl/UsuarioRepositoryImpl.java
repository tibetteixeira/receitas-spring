package io.github.tibetteixeira.api.v1.domain.repository.impl;

import io.github.tibetteixeira.api.v1.domain.entity.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioRepositoryImpl {

    private EntityManager entityManager;

    public UsuarioRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
