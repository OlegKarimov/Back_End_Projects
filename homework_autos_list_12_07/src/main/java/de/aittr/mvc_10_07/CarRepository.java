package de.aittr.mvc_10_07;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {
    private static List<Car> list = new ArrayList<>(
            List.of(new Car("Mercedes","DE234234"),
                    new Car("BMW","DU23432"),
                    new Car("AUDI","GB23434"),
                    new Car("Honda","RA234234"),
                    new Car("Mazda","KB234234")
            ));

    public List<Car> findAll(){
        return list;
    }

    public Optional<Car> findByID(Long id) {
        return list.stream()
                .filter(a->a.getId().equals(id))
                .findFirst();
    }
}
