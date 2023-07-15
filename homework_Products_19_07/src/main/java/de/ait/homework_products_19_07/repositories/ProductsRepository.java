package de.ait.homework_products_19_07.repositories;

import de.ait.homework_products_19_07.models.Product;

import java.util.List;

public interface ProductsRepository {
    List<Product> getAll();
}
