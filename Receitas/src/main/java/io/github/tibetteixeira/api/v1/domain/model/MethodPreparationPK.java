package io.github.tibetteixeira.api.v1.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter @Setter
@Embeddable
public class MethodPreparationPK implements Serializable {

    @Column
    private Integer order;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
}
