package de.ait.homework_products_19_07.services.impl;

import de.ait.homework_products_19_07.models.Product;
import de.ait.homework_products_19_07.repositories.ProductsRepository;
import de.ait.homework_products_19_07.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;

    public ProductServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }


    @Override
    public List<Product> getAllProducts() {
        return productsRepository.getAll();
    }
}
