package com.inventory.adapters.persistence;

import com.inventory.domain.Product;
import com.inventory.domain.ProductRepository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ProductRepositoryImpl implements ProductRepository {
    private final ConcurrentHashMap<String, Product> products = new ConcurrentHashMap<>();

    @Override public void save(Product product) { products.put(product.getId(), product); }
    @Override public Optional<Product> findById(String id) { return Optional.ofNullable(products.get(id)); }
    @Override public List<Product> findAll() { return new ArrayList<>(products.values()); }
    @Override public void delete(String id) { products.remove(id); }
}
