package com.design.patterns.structural.decorator;

import com.design.patterns.structural.decorator.service.AccountService;
import com.design.patterns.structural.decorator.service.impl.AccountServiceImpl;

public class DecoratorApp {

  public static void main(String[] args) {
    AccountService accountService = new AccountServiceImpl();
    accountService.deposit(1000.00);

    AccountWithInterest accountWithInterest = new AccountWithInterest(accountService, 0.05);
    accountWithInterest.applyInterest();

    AccountWithCommission accountWithCommission = new AccountWithCommission(accountWithInterest,
        4.0);
    accountWithCommission.withdraw(500.0);
  }
}
