package io.github.tibetteixeira.api.v1.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column
    private String senha;

    @Column(length = 20)
    private String nome;

    @Column(length = 20)
    private String sobrenome;

    @Column(length = 100)
    private String email;

    @Embedded
    private DataAuditoria dataAuditoria;

    @OneToMany(mappedBy = "usuario")
    private List<Receita> receitas;

    @ManyToMany
    @JoinTable(name = "receitas_favoritas",
                joinColumns = @JoinColumn(name = "id_usuario"),
                inverseJoinColumns = @JoinColumn(name = "id_receita"))
    private List<Receita> receitasFavoritas;

    @OneToMany(mappedBy = "avaliacaoReceitaPK.usuario")
    private List<AvaliacaoReceita> avaliacoes;

    @OneToMany(mappedBy = "usuario")
    private List<ComentarioReceita> comentarioReceitas;

}
