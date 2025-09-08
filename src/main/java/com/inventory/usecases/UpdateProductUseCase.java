package com.inventory.usecases;

import com.inventory.domain.Product;
import com.inventory.domain.ProductRepository;
import java.util.NoSuchElementException;

public class UpdateProductUseCase {
    private final ProductRepository repo;

    public UpdateProductUseCase(ProductRepository repo) { this.repo = repo; }

    public void execute(String id, String name, Double price, Integer stock) {
        Product product = repo.findById(id).orElseThrow(
                () -> new NoSuchElementException("No existe producto con ID: " + id)
        );

        if (name != null) product.setName(name);
        if (price != null) product.setPrice(price);
        if (stock != null) product.setStock(stock);

        repo.save(product);
    }
}
