package com.example;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton()
public class EmiService {
  private final EmiCalculatorClient emiClient;

  @Inject
  @Client("https://mocki.io/v1/")
  HttpClient httpClient;

  public EmiService(EmiCalculatorClient emiClient) {
    this.emiClient = emiClient;
  }

  public Emi calculate(int loanAmount, double interestRate, int durationYears, int monthlyIncome) {

    Emi fetchedEmi = emiClient.fetch(loanAmount, interestRate, durationYears);
    fetchedEmi.setLoanApproval(2 * fetchedEmi.getMonthlyPayment() < monthlyIncome);

    return fetchedEmi;
  }
}
