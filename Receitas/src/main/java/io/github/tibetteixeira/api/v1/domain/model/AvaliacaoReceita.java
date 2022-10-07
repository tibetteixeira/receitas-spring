package io.github.tibetteixeira.api.v1.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "avaliacao_receita")
public class AvaliacaoReceita implements Serializable {

    @EmbeddedId
    private AvaliacaoReceitaPK avaliacaoReceitaPK;

    @Column
    private Integer score;

}
