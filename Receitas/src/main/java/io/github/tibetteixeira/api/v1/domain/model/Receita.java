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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "receita")
public class Receita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(length = 100)
    private String titulo;

    @Column
    private String descricao;

    @Column
    private Integer tempoPreparo;

    @Column
    private Integer porcao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @Embedded
    private DataAuditoria dataAuditoria;

    @ManyToMany
    @JoinTable(name = "ingrediente_receita",
                joinColumns = @JoinColumn(name = "id_receita"),
                inverseJoinColumns = @JoinColumn(name = "id_ingrediente"))
    private List<Ingrediente> ingredientes;

    @ManyToMany(mappedBy = "receitasFavoritas")
    private List<Usuario> usuariosQueFavoritaramReceita;

    @OneToMany(mappedBy = "avaliacaoReceitaPK.receita")
    private List<AvaliacaoReceita> avaliacoes;

    @OneToMany(mappedBy = "receita")
    private List<ComentarioReceita> comentarios;

    @OneToMany(mappedBy = "modoPreparoPK.receita")
    private List<ModoPreparo> modosPreparo;
}
