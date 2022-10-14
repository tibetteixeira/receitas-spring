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
@Table(name = "tb_recipe")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(length = 100)
    private String title;

    @Column
    private String description;

    @Column
    private Integer preparationTime;

    @Column
    private Integer portion;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Embedded
    private AuditDate auditDate;

    @ManyToMany
    @JoinTable(name = "tb_ingredient_recipe",
                joinColumns = @JoinColumn(name = "recipe_id"),
                inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredients;

    @ManyToMany(mappedBy = "favoriteRecipes")
    private List<User> usersFavoritedRecipe;

    @OneToMany(mappedBy = "ratingPK.recipe")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "recipe")
    private List<Comment> comments;

    @OneToMany(mappedBy = "methodPreparationPK.recipe")
    private List<MethodPreparation> methodPreparations;
}
