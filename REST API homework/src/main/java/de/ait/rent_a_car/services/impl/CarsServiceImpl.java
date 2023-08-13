package de.ait.rent_a_car.services.impl;
import de.ait.rent_a_car.services.CarsService;
import de.ait.rent_a_car.models.Car;
import de.ait.rent_a_car.repositories.CarsRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarsServiceImpl implements CarsService {

    private final CarsRepository carsRepository;

    public CarsServiceImpl(CarsRepository carsRepository) {

        this.carsRepository = carsRepository;
    }

    @Override
    public List<Car> getAllCars() {

        return carsRepository.findAll();
    }
}