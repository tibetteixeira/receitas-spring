package io.github.tibetteixeira.api.v1.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "tb_user")
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "tb_user_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "tb_user_id_seq", sequenceName = "tb_user_id_seq", allocationSize = 1)
    @Column(name = "user_id")
    private Integer id;

    @Column
    private String password;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String lastname;

    @Column(length = 100)
    private String email;

    @Embedded
    private AuditDate auditDate;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Recipe> recipes;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "tb_favorite_recipes",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private List<Recipe> favoriteRecipes;

    @JsonIgnore
    @OneToMany(mappedBy = "ratingPK.user")
    private List<Rating> rating;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Comment> comment;

    public User() {
        auditDate = new AuditDate();
    }

}
