package de.aittr.mvc_10_07;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepository repisitory;
    public CarService(CarRepository repisitory) {
        this.repisitory = repisitory;
    }

    List<Car> getAllCars(){
        return repisitory.findAll();
    }



}
