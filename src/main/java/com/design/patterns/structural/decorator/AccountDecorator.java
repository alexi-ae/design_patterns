package com.design.patterns.structural.decorator;

import com.design.patterns.structural.decorator.service.AccountService;

abstract class AccountDecorator implements AccountService {

  protected AccountService accountService;

  public AccountDecorator(
      AccountService accountService) {
    this.accountService = accountService;
  }

  @Override
  public void deposit(double amount) {
    accountService.deposit(amount);
  }

  @Override
  public void withdraw(double amount) {
    accountService.withdraw(amount);
  }

  @Override
  public double getBalance() {
    return accountService.getBalance();
  }
}
