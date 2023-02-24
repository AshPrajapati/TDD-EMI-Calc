package co.incubyte.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CarControllerShould {

  @Mock CarService carService;
  CarController carController;

  @Test
  @DisplayName("call the service")
  void call_the_service() {
    carController = new CarController(carService);
    carController.getCarWrapper("1");
    Mockito.verify(carService).getCarWrapper("1");
  }
   @Test
   @DisplayName("call the service for get all cars")
   void call_the_service_for_get_all_cars() {
     carController = new CarController(carService);
     carController.getAllCars();
     Mockito.verify(carService).getAllCars();

    }

    @Test
    @DisplayName("call the service for get all cars by year")
    void call_the_service_for_get_all_cars_by_year() {
        carController = new CarController(carService);
        carController.getAllCarsByYear(2008);
        Mockito.verify(carService).getAllCarsByYear(2008);

     }

     @Test
     @DisplayName("call the service for get all cars by model")
     void call_the_service_for_get_all_cars_by_model() {

         carController = new CarController(carService);
         carController.getAllCarsByModel("Montero");
         Mockito.verify(carService).getAllCarsByModel("Montero");
      }
}
