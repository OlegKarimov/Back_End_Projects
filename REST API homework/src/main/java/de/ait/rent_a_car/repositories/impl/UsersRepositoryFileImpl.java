package de.ait.rent_a_car.repositories.impl;
import de.ait.rent_a_car.models.User;
import de.ait.rent_a_car.repositories.UsersRepository;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class UsersRepositoryFileImpl implements UsersRepository {

    private String fileName = "users.txt";

    @Override
    public void save(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(user.getEmail() + "#" + user.getPassword());
        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }
    }

    @Override
    public List<User> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            return reader.lines()
                    .map(line -> line.split("#"))// разбил строки по #
                    .map(array -> new User(array[0], array[1]))// превратил массив строк в объект
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }
    }
}
