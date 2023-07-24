package de.ait.rent_a_car.services;
import de.ait.rent_a_car.models.User;
import de.ait.rent_a_car.repositories.UsersRepository;

import java.util.List;


public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {

        this.usersRepository = usersRepository;
    }

    public void signUp(String email, String password) {

        if (!email.contains("@")) {
            throw new IllegalArgumentException("Плохой email");
        }

        if (password.length() < 5) {
            throw new IllegalArgumentException("Плохой пароль!");
        }

        User user = new User(email, password);

        usersRepository.save(user);
    }

    public List<User> getAllUsers() {

        return usersRepository.findAll();
    }
}
