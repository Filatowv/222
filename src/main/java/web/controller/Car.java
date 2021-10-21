package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Car {

    private String model;
    private int series;
    private String color;


    public Car() {
    }

    public Car(String model, int series, String color) {
        this.model = model;
        this.series = series;
        this.color = color;
    }

//        @RequestMapping("/cars")
    @GetMapping(value = "/cars")
    public String getCarsList(ModelMap modelMap,@RequestParam int count) {
        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car("BMW", 5, "Black"));
        carsList.add(new Car("Mercedes", 350, "Yellow"));
        carsList.add(new Car("Toyota", 200, "Black"));
        carsList.add(new Car("Lada", 2110, "Grey"));
        carsList.add(new Car("Lexus", 500, "White"));
//        int count = Integer.parseInt(request.getParameter("count"));
        List<Car> result = carsList.subList(0, count);
        modelMap.addAttribute("result", result);
        return "cars";
    }

    @Override
    public String toString() {
        return "Car: model = " + model +
                ", series = " + series +
                ", color = " + color;
    }
}
