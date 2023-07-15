package de.ait.homework_products_19_07.repositories.impl;

import de.ait.homework_products_19_07.models.Product;
import de.ait.homework_products_19_07.repositories.ProductsRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductsRepositoryImpl implements ProductsRepository {

    private List<Product> products;


    public ProductsRepositoryImpl() {
        Product product1 = new Product(1L, "coffee", 5,true);
        Product product2 = new Product(2L, "bread", 5,true);
        Product product3 = new Product(3L, "milk", 5,false);
        Product product4 = new Product(4L, "sugar", 5,true);

        this.products = Arrays.asList(product1, product2, product3, product4);

    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
