package de.ait.rent_a_car;
import de.ait.rent_a_car.models.User;
import de.ait.rent_a_car.repositories.impl.UsersRepositoryFileImpl;


public class Main2 {
    public static void main(String[] args) {
        UsersRepositoryFileImpl usersRepository = new UsersRepositoryFileImpl();
        User user = new User("marsel@gmail.com", "qwerty007");
        usersRepository.save(user);
    }
}
