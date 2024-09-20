package com.design.patterns.structural.decorator;

import com.design.patterns.structural.decorator.service.AccountService;

public class AccountWithInterest extends AccountDecorator {

  private double interestRate;

  public AccountWithInterest(AccountService accountService, double interestRate) {
    super(accountService);
    this.interestRate = interestRate;
  }

  public void applyInterest() {
    System.out.println("applyInterest");
    double interest = getBalance() * interestRate;
    deposit(interest);
    System.out.println("Interés aplicado: " + interest + ". Saldo actual: " + getBalance());
  }
}
