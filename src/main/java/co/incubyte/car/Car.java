package co.incubyte.car;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
  private String id;
  private String carMake;
  private int year;
  private String carModel;

  public Car(
      @JsonProperty("id") String id,
      @JsonProperty("car") String carMake,
      @JsonProperty("car_model_year") int year,
      @JsonProperty("car_model") String carModel) {
    this.id = id;
    this.carMake = carMake;

    this.year = year;
    this.carModel = carModel;
  }

  public String getId() {
    return id;
  }

  public String getCarMake() {
    return carMake;
  }

  public int getYear() {
    return year;
  }

  public String getCarModel() {
    return carModel;
  }
}
