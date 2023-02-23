package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Emi {
  private final int interestPaid;
  private boolean loanApproval;
  private int monthlyPayment;

  public Emi(
      @JsonProperty("total_interest_paid") int interestPaid,
      @JsonProperty("total") int monthlyPayment) {
    this.interestPaid = interestPaid;
    this.monthlyPayment = monthlyPayment;
  }

  public int getInterestPaid() {
    return interestPaid;
  }

  public boolean getLoanApproval() {
    return loanApproval;
  }

  public void setLoanApproval(boolean loanApproval) {
    this.loanApproval = loanApproval;
  }

  public int getMonthlyPayment() {
    return monthlyPayment;
  }
}
