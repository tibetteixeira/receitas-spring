package io.github.tibetteixeira.api.v1.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "tb_ingredient")
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    TODO incluir id generator sequence
    @Column(name = "ingredient_id")
    private Integer id;

    @Column
    private Float amount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "unit_abbr")
    private Unit unit;

    @JsonIgnore
    @ManyToMany(mappedBy = "ingredients")
    private List<Recipe> recipes;

}
