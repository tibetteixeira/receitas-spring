package io.github.tibetteixeira.api.v1.domain.service;

import io.github.tibetteixeira.api.v1.domain.model.Ingredient;

import java.util.List;

public interface IngredientService extends CrudService<Ingredient, Integer> {

    List<Ingredient> findByProduct(Integer productId);
}
