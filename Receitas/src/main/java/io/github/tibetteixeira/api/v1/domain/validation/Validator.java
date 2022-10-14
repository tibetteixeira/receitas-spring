package io.github.tibetteixeira.api.v1.domain.validation;

public interface Validator<T> {
    void validar(T objeto);
}
