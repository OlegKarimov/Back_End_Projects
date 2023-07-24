
package de.ait.services.impl;


import de.ait.models.Product;
import de.ait.repositories.ProductsRepository;
import de.ait.services.ProductsService;
import de.ait.validators.NameValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor // делает конструктор для final-полей
@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;

    private final NameValidator nameValidator;

    @Override
    public void signUp(Long id, String name, Integer quantity, Boolean valid) {

        nameValidator.validate(name);

        Product product = new Product(id, name, quantity, valid);

        productsRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }
}
