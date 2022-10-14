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
@Table(name = "tb_unit")
public class Unit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 3)
    private String abbr;

    @Column(length = 20)
    private String description;

    @OneToMany(mappedBy = "unit")
    private List<Ingredient> ingredients;

}
