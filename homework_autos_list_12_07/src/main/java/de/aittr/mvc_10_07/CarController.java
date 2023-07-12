package de.aittr.mvc_10_07;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private CarService service;

    public CarController(CarService service) {
        this.service = service;
    }


    @GetMapping // анотация для GET
    public String getAllCars(Model model){
        List<Car> cars = service.getAllCars();
        model.addAttribute("cars", cars);
        return "cars_view";
    }
}
