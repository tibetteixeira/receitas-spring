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
@Table(name = "tb_rating")
public class Rating implements Serializable {

    @EmbeddedId
    private RatingPK ratingPK;

    @Column
    private Integer score;

}
