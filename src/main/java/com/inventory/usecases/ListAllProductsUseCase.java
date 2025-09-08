package com.inventory.usecases;

import com.inventory.domain.Product;
import com.inventory.domain.ProductRepository;
import java.util.List;

public class ListAllProductsUseCase {
    private final ProductRepository repo;

    public ListAllProductsUseCase(ProductRepository repo) { this.repo = repo; }

    public List<Product> execute() { return repo.findAll(); }
}
