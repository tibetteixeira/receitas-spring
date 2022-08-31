package io.github.tibetteixeira.api.v1.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Receita {

    private Integer id;
    private String titulo;
    private String descricao;
    private Integer tempoPreparo;
    private Integer porcao;
    private Usuario usuario;
    private Categoria categoria;
    private DataAuditoria dataAuditoria;
    private Ingrediente ingrediente;

}
