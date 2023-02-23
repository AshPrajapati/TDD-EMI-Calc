package com.example;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@MicronautTest
public class CurrencyCalculatorTest {
  @Client("/")
  @Inject()
  HttpClient httpClient;

  @Test
  @DisplayName("emi should be approved if Emi is more than half of the income")
  void emi_should_be_approved_if_emi_is_more_than_half_of_the_income() {

    int loanAmount = 200000;

    double interestRate = 3.5;

    int monthlyIncome = 50000;
    Emi emi =
        httpClient
            .toBlocking()
            .retrieve(
                "emi-calculator/30?loanAmount="
                    + loanAmount
                    + "&interestRate="
                    + interestRate
                    + "&monthlyIncome="
                    + monthlyIncome,
                Emi.class);
    boolean approval = emi.getLoanApproval();

    Assertions.assertThat(approval).isTrue();
  }

  @Test
  @DisplayName("EMI should be calculated")
  void emi_should_be_calculated() {

    int loanAmount = 200000;

    double interestRate = 3.5;
    int durationYears = 30;
    int monthlyIncome = 50000;

    Emi emi =
        httpClient
            .toBlocking()
            .retrieve(
                "emi-calculator/30?loanAmount="
                    + loanAmount
                    + "&interestRate="
                    + interestRate
                    + "&monthlyIncome="
                    + monthlyIncome,
                Emi.class);
    int interestPaid = emi.getInterestPaid();
    int monthlyPayment = emi.getMonthlyPayment();

    Assertions.assertThat(interestPaid).isEqualTo(123312);
    Assertions.assertThat(monthlyPayment).isEqualTo(898);
  }
}
