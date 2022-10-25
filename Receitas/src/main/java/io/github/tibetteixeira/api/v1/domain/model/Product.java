package io.github.tibetteixeira.api.v1.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_product_id_seq")
    @SequenceGenerator(name = "tb_product_id_seq", sequenceName = "tb_product_id_seq", allocationSize = 1)
    @Column(name = "product_id")
    private Integer id;

    @Column(length = 100)
    @ColumnTransformer(write = "UPPER(?)")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Ingredient> ingredients;

}
