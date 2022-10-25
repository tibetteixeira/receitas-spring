package io.github.tibetteixeira.api.v1.controller;

import io.github.tibetteixeira.api.v1.domain.model.Product;
import io.github.tibetteixeira.api.v1.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(path = "/save")
    public void save(@RequestBody Product product) {
        productService.save(product);
    }

    @PutMapping(path = "/update/{id}")
    public void update(@PathVariable Integer id, @RequestBody Product product) {
        productService.update(id, product);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }

    @GetMapping(path = "/findById/{id}")
    public Product find(@PathVariable Integer id) {
        return productService.findById(id);
    }

    @GetMapping(path = "/findByDescription/{description}")
    public List<Product> findByDescription(@PathVariable String description) {
        return productService.findByDescription(description);
    }

    @GetMapping(path = "/findAll")
    public List<Product> findAll() {
        return productService.findAll();
    }

}
