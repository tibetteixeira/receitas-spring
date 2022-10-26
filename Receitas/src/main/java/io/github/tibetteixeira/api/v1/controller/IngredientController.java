package io.github.tibetteixeira.api.v1.controller;

import io.github.tibetteixeira.api.v1.domain.model.Ingredient;
import io.github.tibetteixeira.api.v1.domain.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ingredient")
public class IngredientController {

    @Autowired
    IngredientService service;

    @PostMapping(path = "/save")
    public void save(@RequestBody Ingredient ingredient) {
        service.save(ingredient);
    }

    @PutMapping(path = "/update/{id}")
    public void update(@PathVariable Integer id, @RequestBody Ingredient ingredient) {
        service.update(id, ingredient);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping(path = "/findByProduct/{productId}")
    public List<Ingredient> findByProduct(@PathVariable Integer productId) {
        return service.findByProduct(productId);
    }

    @GetMapping(path = "/findByRecipe/{recipeId}")
    public List<Ingredient> findByRecipe(@PathVariable Integer recipeId) {
        // TODO: TBD
        return null;
    }

    @GetMapping(path = "/findAll")
    public List<Ingredient> findAll() {
        return service.findAll();
    }
}
