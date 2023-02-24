package co.incubyte.car;

import jakarta.inject.Singleton;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Singleton
public class CarService {
    private CarClient carClient;

    public CarService(CarClient carClient) {

        this.carClient = carClient;
    }

    public CarWrapper getCarWrapper(String id) {
        return carClient.fetch(id);
    }

    public ListCarWrapper getAllCars() {
        return carClient.fetchAll();
    }

    public List<Car> getAllCarsByYear(int year) {
        ListCarWrapper listCarWrapper=getAllCars();
        List<Car> cars = listCarWrapper.getCars();
        return cars.stream().filter(car->car.getYear()==year).collect(Collectors.toList());
    }

    public List<Car> getAllCarsByModel(String model) {
        ListCarWrapper listCarWrapper=getAllCars();
        List<Car> cars = listCarWrapper.getCars();
        return cars.stream().filter(car -> { return Objects.equals(car.getCarModel(), model); }).collect(Collectors.toList());
    }
}
