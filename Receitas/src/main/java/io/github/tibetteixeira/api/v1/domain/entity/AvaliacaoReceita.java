package io.github.tibetteixeira.api.v1.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AvaliacaoReceita {

    private Integer score;
    private Usuario usuario;
    private Receita receita;

}
