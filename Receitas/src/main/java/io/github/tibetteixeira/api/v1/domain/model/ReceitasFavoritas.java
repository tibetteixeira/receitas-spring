package io.github.tibetteixeira.api.v1.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReceitasFavoritas {

    private Usuario usuario;
    private Receita receita;

}
