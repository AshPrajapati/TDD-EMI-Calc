package co.incubyte.car;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/")
public class CarController {
  private CarService carService;

  public CarController(CarService carService) {

    this.carService = carService;
  }

  @Get("cars/{id}")
  public CarWrapper getCarWrapper(String id) {
    return this.carService.getCarWrapper(id);
  }

  @Get("cars")
  public ListCarWrapper getAllCars() {
    return this.carService.getAllCars();
  }

  @Get("cars/years/{year}")
  public List<Car> getAllCarsByYear(int year) {
    return this.carService.getAllCarsByYear(year);
  }

  @Get("cars/models/{model}")
  public List<Car> getAllCarsByModel(String model) {
    return this.carService.getAllCarsByModel(model);
  }
}
