package co.incubyte.car;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
public class CarControllerTest {
  @Inject
  @Client("/")
  HttpClient httpClient;

  @Test
  @DisplayName("should get car by id")
  void should_get_car_by_id() {
    CarWrapper carWrapper = httpClient.toBlocking().retrieve("cars/1", CarWrapper.class);
    Car responseCar = carWrapper.getCar();
    assertThat(responseCar.getId()).isEqualTo("1");
    assertThat(responseCar.getCarMake()).isEqualTo("Mitsubishi");
  }

  @Test
  @DisplayName("should get all cars")
  void should_get_all_cars() {
    ListCarWrapper listCarWrapper = httpClient.toBlocking().retrieve("cars", ListCarWrapper.class);
    List<Car> cars = listCarWrapper.getCars();
    assertThat(cars.size()).isEqualTo(1000);
  }

  @Test
  @DisplayName("should get all cars whose year is 2008")
  void should_get_all_cars_whose_year_is_2008() {
    List<Car> cars = httpClient.toBlocking().retrieve(HttpRequest.GET("cars/years/2008"), Argument.listOf(Car.class));
    assertThat(cars.size()).isEqualTo(48);
    assertThat(cars).allSatisfy(car -> assertThat(car.getYear()).isEqualTo(2008));
  }
  
  @Test
  @DisplayName("should get all cars by model")
  void  should_get_all_cars_by_model() {
    List<Car> cars = httpClient.toBlocking().retrieve(HttpRequest.GET("cars/models/Montero"), Argument.listOf(Car.class));
    assertThat(cars.size()).isEqualTo(3);
    assertThat(cars).allSatisfy(car -> assertThat(car.getCarModel()).isEqualTo("Montero"));
   }
}
