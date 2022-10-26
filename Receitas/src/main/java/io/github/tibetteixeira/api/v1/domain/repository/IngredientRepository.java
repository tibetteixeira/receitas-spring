package io.github.tibetteixeira.api.v1.domain.repository;

import io.github.tibetteixeira.api.v1.domain.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
