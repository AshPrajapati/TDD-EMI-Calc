package co.incubyte.car;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarWrapper {
  private final Car car;

  public CarWrapper(@JsonProperty("Car") Car car) {
    this.car = car;
  }

  public Car getCar() {
    return car;
  }
}
