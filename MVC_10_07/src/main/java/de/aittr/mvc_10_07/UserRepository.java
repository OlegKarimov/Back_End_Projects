package de.aittr.mvc_10_07;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private List<User> list = new ArrayList<>(
            List.of(new User("Jack","Berlin"),
                    new User("Oleg","Kiev"),
                    new User("Lena","Kiev"),
                    new User("Vasya","Postdam"),
                    new User("Katya","Berlin")
            ));

    public List<User> findAll(){
        return list;
    }

    public Optional<User> findByID(Long id){
        return list.stream()
                .filter(u->u.getId().equals((id)))
                .findFirst();
    }



}
