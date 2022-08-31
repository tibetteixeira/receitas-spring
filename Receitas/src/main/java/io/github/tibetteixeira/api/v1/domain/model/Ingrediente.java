package io.github.tibetteixeira.api.v1.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Ingrediente {

    private Integer id;
    private Float quantidade;
    private Produto produto;
    private Unidade unidade;
    private Receita receita;

}
