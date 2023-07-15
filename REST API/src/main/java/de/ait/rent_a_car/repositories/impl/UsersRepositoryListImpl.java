package de.ait.rent_a_car.repositories.impl;
import de.ait.rent_a_car.models.User;
import de.ait.rent_a_car.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;


public class UsersRepositoryListImpl implements UsersRepository {
    private List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        this.users.add(user);
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
