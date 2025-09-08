package com.inventory.adapters.controller;

import com.inventory.domain.Product;
import com.inventory.usecases.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Controlador que actúa como fachada para los casos de uso.
 * Mejora los mensajes de error para que sean seguros y claros.
 */
public class ProductController {
    private final AddProductUseCase addProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final ListAllProductsUseCase listAllProductsUseCase;

    public ProductController(AddProductUseCase addProductUseCase,
                             UpdateProductUseCase updateProductUseCase,
                             DeleteProductUseCase deleteProductUseCase,
                             ListAllProductsUseCase listAllProductsUseCase) {
        this.addProductUseCase = addProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
        this.listAllProductsUseCase = listAllProductsUseCase;
    }

    public void addProduct(Product product, String userRole) {
        try {
            addProductUseCase.execute(product, userRole);
            System.out.println("Producto agregado con éxito.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado al agregar producto.");
        }
    }

    public void updateProduct(String id, String name, Double price, Integer stock) {
        try {
            updateProductUseCase.execute(id, name, price, stock);
            System.out.println("Producto con ID '" + id + "' actualizado con éxito.");
        } catch (NoSuchElementException e) {
            System.err.println("No se encontró el producto: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado al actualizar producto.");
        }
    }

    public void deleteProduct(String id) {
        try {
            deleteProductUseCase.execute(id);
            System.out.println("Producto eliminado con éxito.");
        } catch (NoSuchElementException e) {
            System.err.println("No se encontró el producto: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado al eliminar producto.");
        }
    }

    public void listAllProducts() {
        try {
            List<Product> products = listAllProductsUseCase.execute();
            if (products.isEmpty()) {
                System.out.println("ℹ️ No hay productos en el inventario.");
            } else {
                System.out.println("\n--- Lista de Productos ---");
                products.forEach(System.out::println);
                System.out.println("--------------------------");
            }
        } catch (Exception e) {
            System.err.println("Error inesperado al listar productos.");
        }
    }
}
