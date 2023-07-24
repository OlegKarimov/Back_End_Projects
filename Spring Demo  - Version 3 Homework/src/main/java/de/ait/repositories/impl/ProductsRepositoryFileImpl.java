
package de.ait.repositories.impl;

import de.ait.models.Product;
import de.ait.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class ProductsRepositoryFileImpl implements ProductsRepository {

    private final String fileName;

    public
    ProductsRepositoryFileImpl(@Value("${file.name}") String fileName) {

        this.fileName = fileName;
    }

    @Override
    public void save(Product product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(product.getId() + "#" +
                    product.getName() + "#" +
                    product.getQuantity() + "#" +
                    product.getValid());
        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }
    }

    @Override
    public List<Product> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            return reader.lines()
                    .map(line -> line.split("#"))// разбил строки по #
                    .map(array -> new Product(Long.parseLong(array[0]), array[1], Integer.parseInt(array[2]), Boolean.parseBoolean(array[3])))// превратил массив строк в объект
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }
    }
}
