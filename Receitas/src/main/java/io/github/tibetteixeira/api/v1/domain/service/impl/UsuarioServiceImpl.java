package io.github.tibetteixeira.api.v1.domain.service.impl;

import io.github.tibetteixeira.api.v1.domain.model.Usuario;
import io.github.tibetteixeira.api.v1.domain.repository.UsuarioRepository;
import io.github.tibetteixeira.api.v1.domain.service.UsuarioService;
import io.github.tibetteixeira.api.v1.domain.exception.UsuarioException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }


    @Override
    public void salvar(Usuario usuario) {
        repository.save(usuario);
    }

    @Override
    public void atualizar(Usuario usuario) {
        repository.save(usuario);
    }

    @Override
    public void remover(Usuario usuario) {
        repository.delete(usuario);
    }

    @Override
    public Usuario listarPorCodigo(Integer codigo) {
        return repository.findById(codigo).orElseThrow(() ->
                new UsuarioException(String.format("Usuário com cóigo %d não encontrado!", codigo)));
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll();
    }


    @Override
    public List<Usuario> listarPorNome(String nome) {
        return repository.findByNomeLike(nome);
    }
}
