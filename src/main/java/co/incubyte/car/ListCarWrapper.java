package co.incubyte.car;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListCarWrapper {
    List<Car> cars;

    @JsonCreator
    public ListCarWrapper(@JsonProperty("cars") List<Car> cars) {
        this.cars = cars;
    }

    public void addCars(Car...car){
        cars.addAll(List.of(car));
    }

    public List<Car> getCars() {
        return this.cars;
    }



}
