package de.ait.rent_a_car.repositories;

import de.ait.rent_a_car.models.Car;

import java.util.List;

public interface CarsRepository {
    List<Car> findAll();
}
