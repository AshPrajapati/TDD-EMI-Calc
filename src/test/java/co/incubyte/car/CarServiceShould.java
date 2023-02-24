package co.incubyte.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CarServiceShould {
  CarService carService;

  @Mock CarClient carClient;

  @Test
  @DisplayName("call car client")
  void call_car_client() {
    carService = new CarService(carClient);
    carService.getCarWrapper("1");
    Mockito.verify(carClient).fetch("1");
  }

  @Test
  @DisplayName("call get all cars")
  void call_get_all_cars() {
    carService = new CarService(carClient);
    carService.getAllCars();
    Mockito.verify(carClient).fetchAll();
  }

  @Test
  @DisplayName("call get cars by year")
  void call_get_cars_by_year() {
    carService = new CarService(carClient);

    Mockito.when(carClient.fetchAll())
        .thenReturn(
            new ListCarWrapper(
                List.of(
                    new Car("1", "Mitsubishi", 2002,"Montero"),
                    new Car("2", "Nano", 2008,"Montero"),
                    new Car("3", "Hyundai", 2008,"Passat"),
                    new Car("4", "Creta", 2009,"Passat"))));

    List<Car> cars = carService.getAllCarsByYear(2008);

    Mockito.verify(carClient).fetchAll();
    Assertions.assertThat(cars.size()).isEqualTo(2);
    assertThat(cars).allSatisfy(car -> assertThat(car.getYear()).isEqualTo(2008));
  }

  @Test
  @DisplayName("call get cars by model")
  void call_get_cars_by_model() {
    carService = new CarService(carClient);

    Mockito.when(carClient.fetchAll())
            .thenReturn(
                    new ListCarWrapper(
                            List.of(
                                    new Car("1", "Mitsubishi", 2002,"Montero"),
                                    new Car("2", "Nano", 2008,"Montero"),
                                    new Car("3", "Hyundai", 2008,"Passat"),
                                    new Car("4", "Creta", 2009,"Passat"))));

    List<Car> cars = carService.getAllCarsByModel("Montero");

    Mockito.verify(carClient).fetchAll();
    Assertions.assertThat(cars.size()).isEqualTo(2);
    assertThat(cars).allSatisfy(car -> assertThat(car.getCarModel()).isEqualTo("Montero"));
   }
}
