package io.github.tibetteixeira.api.v1.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_method_preparation")
public class MethodPreparation implements Serializable {

    @EmbeddedId
    private MethodPreparationPK methodPreparationPK;

    @Column
    private String description;
}
