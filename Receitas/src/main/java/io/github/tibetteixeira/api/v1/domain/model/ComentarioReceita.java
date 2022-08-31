package io.github.tibetteixeira.api.v1.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ComentarioReceita {

    private Integer id;
    private String titulo;
    private String comentario;
    private Usuario usuario;
    private Receita receita;
    private DataAuditoria dataAuditoria;

}
