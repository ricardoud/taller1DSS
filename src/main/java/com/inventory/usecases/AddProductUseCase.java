package com.inventory.usecases;

import com.inventory.domain.Product;
import com.inventory.domain.ProductRepository;

/**
 * Caso de uso para agregar un nuevo producto.
 * Incluye validación de rol (autorización).
 */
public class AddProductUseCase {
    private final ProductRepository productRepository;

    public AddProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Ejecuta la lógica para agregar un producto.
     * @param product Producto a agregar.
     * @param userRole Rol del usuario (ej: "ADMIN").
     * @throws IllegalArgumentException Si el producto ya existe o el rol no está autorizado.
     */
    public void execute(Product product, String userRole) {
        if (!"ADMIN".equals(userRole)) {
            throw new IllegalArgumentException("No autorizado: solo un administrador puede agregar productos.");
        }

        if (productRepository.findById(product.getId()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un producto con el ID: " + product.getId());
        }

        productRepository.save(product);
    }
}
