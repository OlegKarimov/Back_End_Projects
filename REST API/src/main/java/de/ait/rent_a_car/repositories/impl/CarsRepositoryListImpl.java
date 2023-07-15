package de.ait.rent_a_car.repositories.impl;

import de.ait.rent_a_car.models.Car;
import de.ait.rent_a_car.repositories.CarsRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


@Repository
public class CarsRepositoryListImpl implements CarsRepository {

    private List<Car> cars;

    public CarsRepositoryListImpl() {
        Car car1 = new Car(1L, "BMW", "Black");
        Car car2 = new Car(2L, "Audi", "Red");
        Car car3 = new Car(3L, "Mercedes", "Silver");
        Car car4 = new Car(4L, "Ford", "Blue");
        this.cars = Arrays.asList(car1, car2, car3, car4);
    }
    @Override
    public List<Car> findAll() {

        return cars;
    }
}