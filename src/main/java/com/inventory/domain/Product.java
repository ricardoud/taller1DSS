package com.inventory.domain;

/**
 * Entidad de dominio que representa un producto.
 * Incluye validaciones avanzadas para mayor seguridad.
 */
public class Product {
    private final String id;
    private String name;
    private double price;
    private int stock;

    public Product(String id, String name, double price, int stock) {
        validateId(id);
        validateName(name);
        validatePrice(price);
        validateStock(stock);

        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    private void validateId(String id) {
        if (id == null || !id.matches("[A-Z0-9_-]{5,20}")) {
            throw new IllegalArgumentException(" ID inválido. Debe tener entre 5 y 20 caracteres (mayúsculas, números, guion o guion bajo).");
        }
    }

    private void validateName(String name) {
        if (name == null || !name.matches("[a-zA-Z0-9 ]+")) {
            throw new IllegalArgumentException("Nombre inválido. Solo se permiten letras, números y espacios.");
        }
    }

    private void validatePrice(double price) {
        if (price <= 0 || price > 1000000) {
            throw new IllegalArgumentException("Precio inválido. Debe estar entre 1 y 1,000,000.");
        }
    }

    private void validateStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Stock inválido. No puede ser negativo.");
        }
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) {
        validatePrice(price);
        this.price = price;
    }

    public int getStock() { return stock; }

    public void setStock(int stock) {
        validateStock(stock);
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + name + ", Precio: " + String.format("%.2f", price) + ", Stock: " + stock;
    }
}
