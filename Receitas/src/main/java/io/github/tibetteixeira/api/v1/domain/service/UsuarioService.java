package io.github.tibetteixeira.api.v1.domain.service;

import io.github.tibetteixeira.api.v1.domain.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listarTodos();
}
