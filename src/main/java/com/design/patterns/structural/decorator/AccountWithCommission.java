package com.design.patterns.structural.decorator;

import com.design.patterns.structural.decorator.service.AccountService;

public class AccountWithCommission extends AccountDecorator {

  private double commission;

  public AccountWithCommission(AccountService accountService, double commission) {
    super(accountService);
    this.commission = commission;
  }

  @Override
  public void withdraw(double amount) {
    super.withdraw(amount);
    super.withdraw(commission);
    System.out.println("Comisión aplicada: " + commission + ". Saldo actual: " + getBalance());
  }
}
