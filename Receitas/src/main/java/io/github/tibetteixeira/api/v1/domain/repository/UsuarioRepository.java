package io.github.tibetteixeira.api.v1.domain.repository;

import io.github.tibetteixeira.api.v1.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByNomeLike(String nome);
}
