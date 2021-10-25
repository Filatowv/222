package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;


@Service
public class CarServiceImp implements CarService {

    @Override
    public List<Car> getCars() {
        List<Car> carList = new ArrayList<>();
            carList.add(new Car("BMW",5,2009));
            carList.add(new Car("Mercedes E", 350,2016));
            carList.add(new Car("Toyota Land Cruiser", 200,2013));
            carList.add(new Car("Lada", 2110,2005));
            carList.add(new Car("Lexus GS", 500,2009));
        return carList;
    }

    @Override
    public List<Car> getRequiredNumberOfCars(List<Car> cars, int count) {
        if (count >= 5||cars == null) {
            return cars;
        } else {
            return cars.subList(0, count);
        } //list.stream().limit(count).toList();
    }
}

