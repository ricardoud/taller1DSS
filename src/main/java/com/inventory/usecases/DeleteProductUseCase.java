package com.inventory.usecases;

import com.inventory.domain.ProductRepository;
import java.util.NoSuchElementException;

public class DeleteProductUseCase {
    private final ProductRepository repo;

    public DeleteProductUseCase(ProductRepository repo) { this.repo = repo; }

    public void execute(String id) {
        if (repo.findById(id).isEmpty()) {
            throw new NoSuchElementException("No existe producto con ID: " + id);
        }
        repo.delete(id);
    }
}
