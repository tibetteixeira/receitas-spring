package io.github.tibetteixeira.api.v1.domain.service.impl;

import io.github.tibetteixeira.api.v1.domain.exception.IngredientException;
import io.github.tibetteixeira.api.v1.domain.model.Ingredient;
import io.github.tibetteixeira.api.v1.domain.repository.IngredientRepository;
import io.github.tibetteixeira.api.v1.domain.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.commons.lang3.BooleanUtils.isFalse;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository repository;

    @Override
    public void save(Ingredient ingredient) {
        repository.save(ingredient);
    }

    @Override
    public void update(Integer id, Ingredient ingredient) {
        if (isFalse(id.equals(ingredient.getId())))
            throw new IngredientException("Id do ingrediente diferente do id da Url!");

        findById(id);
        repository.save(ingredient);
    }

    @Override
    public void delete(Integer id) {
        Ingredient ingredient = findById(id);
        repository.delete(ingredient);
    }

    @Override
    public Ingredient findById(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new IngredientException(String.format("Ingrediente com id %d inexistente!", id)));
    }

    @Override
    public List<Ingredient> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Ingredient> findByProduct(Integer productId) {
        // TODO TBD
        return null;
    }
}
