package io.github.tibetteixeira.api.v1.domain.service;

import io.github.tibetteixeira.api.v1.domain.model.Product;

import java.util.List;

public interface ProductService extends CrudService<Product, Integer> {

    List<Product> findByDescription(String description);
}
