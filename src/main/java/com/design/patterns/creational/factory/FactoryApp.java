package com.design.patterns.creational.factory;

import com.design.patterns.creational.factory.service.BankAccountService;

public class FactoryApp {

  public static void main(String[] args) {
    BankAccountFactory accountFactory = new BankAccountFactory();

    BankAccountService accountService1 = accountFactory.getBankAccount("SAVING");
    accountService1.create(1);
    accountService1.deposit();

    BankAccountService accountService2 = accountFactory.getBankAccount("CURRENT");
    accountService2.create(1);

    BankAccountService accountService3 = accountFactory.getBankAccount("PAYROLL");
    accountService3.create(2);
    accountService3.deposit();

    BankAccountService accountService4 = accountFactory.getBankAccount("TIME_DEPOSIT");
    accountService4.create(3);
    accountService4.deposit();
    accountService4.withdraw();
  }
}
