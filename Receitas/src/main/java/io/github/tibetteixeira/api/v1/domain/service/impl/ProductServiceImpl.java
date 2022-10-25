package io.github.tibetteixeira.api.v1.domain.service.impl;

import io.github.tibetteixeira.api.v1.domain.exception.ProductException;
import io.github.tibetteixeira.api.v1.domain.model.Product;
import io.github.tibetteixeira.api.v1.domain.repository.ProductRepository;
import io.github.tibetteixeira.api.v1.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.commons.lang3.BooleanUtils.isFalse;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void update(Integer id, Product product) {
        if (isFalse(id.equals(product.getId())))
            throw new ProductException("Id do produto diferente do id da Url!");

        findById(id);

        repository.save(product);
    }

    @Override
    public void delete(Integer id) {
        Product product = findById(id);
        repository.delete(product);
    }

    @Override
    public Product findById(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new ProductException(String.format("Produto com id %d inexistente!", id)));
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> findByDescription(String description) {
        return repository.findByDescriptionContainsIgnoreCase(description);
    }
}
