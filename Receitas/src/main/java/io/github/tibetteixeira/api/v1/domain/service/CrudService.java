package io.github.tibetteixeira.api.v1.domain.service;

import java.util.List;

public interface CrudService<T, Tid> {

    void salvar(T objeto);
    void atualizar(T objeto);
    void remover(T objeto);
    T listarPorCodigo(Tid codigo);
    List<T> listarTodos();
}
