package de.aittr.mvc_10_07;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private CarRepository repisitory;
    public CarService(CarRepository repisitory) {

        this.repisitory = repisitory;
    }

    public List<Car> getAllCars(){
        return repisitory.findAll();
    }

    public void saveCar(Car car){

    }


    public Optional<Car> getCarById(Long id) {
        Optional<Car> car = repisitory.findByID(id);
        return car;
    }
}
