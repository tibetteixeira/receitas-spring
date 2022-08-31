package io.github.tibetteixeira.api.v1.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ModoPreparo {

    private Integer ordem;
    private String descricao;
    private Receita receita;
}
