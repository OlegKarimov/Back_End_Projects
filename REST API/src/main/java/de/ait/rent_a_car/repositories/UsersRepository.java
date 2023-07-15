package de.ait.rent_a_car.repositories;
import de.ait.rent_a_car.models.User;

import java.util.List;

public interface UsersRepository {
    void save(User user);

    List<User> findAll();
}