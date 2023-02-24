package co.incubyte;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class EmiServiceShould {
  EmiCalculatorClient emiClient;

  @Test
  @DisplayName("call the fetch")
  void call_the_fetch() {
    int loanAmount = 200000;
    double interestRate = 3.5;
    int durationYears = 30;
    int monthlyIncome = 50000;
    emiClient = Mockito.mock(EmiCalculatorClient.class);
    EmiService emiService = new EmiService(emiClient);
    Emi emi = new Emi(123312,898);
    when(emiClient.fetch(loanAmount,interestRate,durationYears)).thenReturn(emi);
    emiService.calculate(loanAmount, interestRate, durationYears, monthlyIncome);
    Mockito.verify(emiClient).fetch(loanAmount, interestRate, durationYears);
  }
@Test
@DisplayName("return true if emi is more half then monthly income")
void return_true_if_emi_is_more_half_then_monthly_income() {

  int loanAmount = 200000;
  double interestRate = 3.5;
  int durationYears = 30;
  int monthlyIncome = 50000;
  emiClient = Mockito.mock(EmiCalculatorClient.class);
  EmiService emiService = new EmiService(emiClient);
  Emi emi = new Emi(123312,898);
  when(emiClient.fetch(loanAmount,interestRate,durationYears)).thenReturn(emi);
  emiService.calculate(loanAmount, interestRate, durationYears, monthlyIncome);
  Assertions.assertThat(emi.getLoanApproval()).isTrue();
 }

  @Test
  @DisplayName("return false if emi is more half then monthly income")
  void return_false_if_emi_is_more_half_then_monthly_income() {

    int loanAmount = 200000;
    double interestRate = 3.5;
    int durationYears = 30;
    int monthlyIncome = 100;
    emiClient = Mockito.mock(EmiCalculatorClient.class);
    EmiService emiService = new EmiService(emiClient);
    Emi emi = new Emi(123312,898);
    when(emiClient.fetch(loanAmount,interestRate,durationYears)).thenReturn(emi);
    emiService.calculate(loanAmount, interestRate, durationYears, monthlyIncome);
    Assertions.assertThat(emi.getLoanApproval()).isFalse();
  }
}


