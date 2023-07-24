
package de.ait.services;

import de.ait.models.Product;

import java.util.List;

public interface ProductsService {
    void signUp(Long id, String name, Integer quantity, Boolean valid);
    List<Product> getAllProducts();
}
