package io.github.tibetteixeira.api.v1.domain.service;

import io.github.tibetteixeira.api.v1.domain.model.Usuario;

import java.util.List;

public interface UsuarioService extends CrudService<Usuario, Integer> {

    List<Usuario> listarPorNome(String nome);
}
