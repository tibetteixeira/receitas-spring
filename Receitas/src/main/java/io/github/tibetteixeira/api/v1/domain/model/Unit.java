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
@Table(name = "tb_unit")
public class Unit implements Serializable {

    @Id
    @Column(length = 3)
    private String abbr;

    @Column(length = 20)
    @ColumnTransformer(write = "UPPER(?)")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "unit")
    private List<Ingredient> ingredients;

    public String getAbbr() {
        return abbr.toUpperCase();
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr.toUpperCase();
    }
}
