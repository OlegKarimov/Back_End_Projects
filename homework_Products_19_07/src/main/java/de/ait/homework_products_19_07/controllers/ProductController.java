package de.ait.homework_products_19_07.controllers;

import de.ait.homework_products_19_07.models.Product;
import de.ait.homework_products_19_07.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    @ResponseBody

    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }




}
