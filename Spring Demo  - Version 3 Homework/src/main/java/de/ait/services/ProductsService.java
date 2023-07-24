
package de.ait.services;

import de.ait.models.Product;

import java.util.List;

public interface ProductsService {
    void signUp(Long id, String name, int quantity, boolean valid);
    List<Product> getAllProducts();
}
