package de.aittr.mvc_10_07;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cars")
public class CarController {
    private CarService service;

    public CarController(CarService service) {

        this.service = service;
    }


    @GetMapping // анотация для GET
    public String getAllCars(Model model){
//        List<Car> cars = service.getAllCars();
        model.addAttribute("cars", service.getAllCars());
        return "cars_view";
    }

    @GetMapping("/add")
    public String getAddForm(Model model){
        Car car = new Car();
        model.addAttribute("car",car);

        return "add_car";
    }

    @PostMapping
    public String postNewCar(@ModelAttribute("car") Car car){
//        System.out.println(car);
        service.saveCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/{car_id}")
    public String getCarByIG(@PathVariable(name = "car_id") Long id, Model model){
        Optional<Car> optionalCar = service.getCarById(id);
        Car car = optionalCar.get();
        model.addAttribute("car", car);
        return "car";
    }
}
