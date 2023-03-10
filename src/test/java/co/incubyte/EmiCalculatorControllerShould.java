package co.incubyte;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmiCalculatorControllerShould {
  EmiCalculatorController emiCalculatorController;
  @Mock EmiService emiService;

  @BeforeEach
  public void init() {
    emiCalculatorController = new EmiCalculatorController(emiService);
  }

  @Test
  @DisplayName("calculate emi")
  void calculate_emi() {
    // given
    int loanAmount = 200000;
    double interestRate = 3.5;
    int durationYears = 30;
    // when
    int monthlyIncome = 50000;
    Emi emi =
        emiCalculatorController.calculate(loanAmount, interestRate, durationYears, monthlyIncome);
    // then
    Mockito.verify(emiService).calculate(loanAmount, interestRate, durationYears, monthlyIncome);
  }
}
