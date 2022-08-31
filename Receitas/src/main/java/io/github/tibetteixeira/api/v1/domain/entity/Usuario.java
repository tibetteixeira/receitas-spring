package io.github.tibetteixeira.api.v1.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "usuario")
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(name = "senha")
    private String senha;

    @Column(name = "nome", length = 20)
    private String nome;

    @Column(name = "sobrenome", length = 20)
    private String sobrenome;


    @Column(name = "email", length = 100)
    private String email;

    @Embedded
    private DataAuditoria dataAuditoria;

}
